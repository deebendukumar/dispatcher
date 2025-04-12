package com.dispatcher.pim.service.impl;

import com.dispatcher.pim.entity.Product;
import com.dispatcher.pim.entity.Variant;
import com.dispatcher.pim.repository.ProductRepository;
import com.dispatcher.pim.repository.VariantRepository;
import com.dispatcher.pim.service.ProductService;
import com.dispatcher.pim.service.VariantService;
import org.ameba.annotation.TxService;
import org.ameba.i18n.Translator;

import java.util.List;
import java.util.NoSuchElementException;

/**
 * A TxService is a stereotype annotation to define a transactional Spring managed service.
 * A Measured is a marker annotation on classes or public methods to indicate that the annotated class or method are being tracked in terms
 */
@TxService
public class ProductServiceImpl implements ProductService<Product> {

    private final ProductRepository repository;
    private final Translator translator;

    ProductServiceImpl(ProductRepository repository, Translator translator) {
        this.repository = repository;
        this.translator = translator;
    }

    @Override
    public Product findByPKey(String id) {
        return repository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException(translator.translate("product.not.found", id)));
    }

    @Override
    public List<Product> findAll() {
        return repository.findAll();
    }

    @Override
    public Product create(Product product) {

        return repository.save(product);

    }

    @Override
    public Product update(String id, Product product) {
        return repository .findById(id)
                .map(existingProduct -> {
                    product.setId(id);
                    return repository.save(product);
                })
                .orElseThrow(() -> new NoSuchElementException("Product with id " + id + " not found"));
    }

    @Override
    public Product delete(String id) {
        return repository.findById(id)
                .map(product -> {
                    repository.delete(product);
                    return product;
                })
                .orElseThrow(() -> new NoSuchElementException("Product with id " + id + " not found"));
    }
}
