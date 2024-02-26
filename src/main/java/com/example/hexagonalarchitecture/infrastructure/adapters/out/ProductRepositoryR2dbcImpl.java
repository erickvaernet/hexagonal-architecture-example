package com.example.hexagonalarchitecture.infrastructure.adapters.out;

import com.example.hexagonalarchitecture.domain.model.Product;
import com.example.hexagonalarchitecture.domain.model.ProductStatus;
import com.example.hexagonalarchitecture.domain.ports.out.ProductRepository;
import com.example.hexagonalarchitecture.infrastructure.adapters.out.database.relational.ProductR2dbcDao;
import com.example.hexagonalarchitecture.infrastructure.adapters.out.database.relational.ProductStatusR2dbcDao;
import com.example.hexagonalarchitecture.infrastructure.adapters.out.database.relational.tables.ProductDb;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Component
@RequiredArgsConstructor
@Primary
public class ProductRepositoryR2dbcImpl implements ProductRepository {

    private final ProductR2dbcDao productR2DbcDao;
    private final ProductStatusR2dbcDao productStatusR2dbcDao ;

    /*
    private Map<Integer, String> statusMap;
    @PostConstruct
    public void init() {
        statusMap = productStatusR2dbcDao.findAll()
                .collectMap(ProductStatusDb::getId, ProductStatusDb::getName)
                .block();
    }
     */

    @Override
    public Mono<Product> save(Product product) {
        return productStatusR2dbcDao.findByName(product.getStatus().name())
                .flatMap(status -> productR2DbcDao.save(
                        ProductDb.builder()
                                .name(product.getName())
                                .statusId(status.getId())
                                .quantity(product.getQuantity())
                                .price(product.getPrice())
                                .build())
                )
                .map(productDb -> product.toBuilder().id(productDb.getId()).build());
    }


    @Override
    public Flux<Product> findAll() {
        return  productR2DbcDao.findAll().flatMap(this::getProductWithStatusFunction);
    }

    @Override
    public Mono<Product> findById(Long id) {
        return productR2DbcDao.findById(id).flatMap(this::getProductWithStatusFunction);
    }

    private Mono<Product> getProductWithStatusFunction(ProductDb productDb) {
        return productStatusR2dbcDao.findById(productDb.getStatusId())
                .map(productStatusDb -> ProductStatus.getValue(productStatusDb.getName()))
                .map(productStatus -> Product.builder()
                        .id(productDb.getId())
                        .name(productDb.getName())
                        .status(productStatus)
                        .price(productDb.getPrice())
                        .build());
    }

    @Override
    public Mono<Void> deleteById(Long id) {
        return productR2DbcDao.deleteById(id);
    }
}
