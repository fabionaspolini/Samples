package com.example.config

import com.example.domain.item.ItemOrder
import com.example.domain.product.Product
import com.example.domain.po.PurchaseOrder
//import com.example.domain.item.ItemRepository
import com.example.domain.product.ProductRepository
//import com.example.domain.po.PurchaseRepository
import org.springframework.boot.CommandLineRunner
import org.springframework.stereotype.Component
import java.math.BigDecimal

@Component
class DatabaseLoader(
        private val productRepository: ProductRepository
//        private val purchaseRepository: PurchaseRepository,
//        private val itemRepository: ItemRepository
): CommandLineRunner {

    override fun run(vararg args: String?) {
        saveProducts()
//        savePurchases()
//        saveItems()
    }

    fun saveProducts(){
        val list = mutableListOf<Product>().apply {
            add(Product(description = "Notebook"))
            add(Product(description = "Desktop"))
            add(Product(description = "Mainframe"))
            add(Product(description = "Tablet"))
            add(Product(description = "SSD Portable"))
            add(Product(description = "Memory Card"))
        }
        productRepository.saveAll(list)
    }

    /*fun savePurchases(){
        val list = mutableListOf<PurchaseOrder>().apply {
            add(PurchaseOrder(customer = "Info Store"))
            add(PurchaseOrder(customer = "PCI Informática"))
            add(PurchaseOrder(customer = "Ramsons"))
            add(PurchaseOrder(customer = "Amazon Print"))
        }
        purchaseRepository.saveAll(list)
    }

    fun saveItems(){
        val list = mutableListOf<ItemOrder>().apply {
            add(ItemOrder(id = 0, product = Product(id = 1), quantity = 2, purchaseOrder = PurchaseOrder(id = 1),
                    value = BigDecimal.valueOf(2490.44)))

            add(ItemOrder(id = 0, product = Product(id = 2), quantity = 4, purchaseOrder = PurchaseOrder(id = 2),
                    value = BigDecimal.valueOf(1090.44)))

            add(ItemOrder(id = 0, product = Product(id = 3), quantity = 6, purchaseOrder = PurchaseOrder(id = 3),
                    value = BigDecimal.valueOf(4550.44)))

            add(ItemOrder(id = 0, product = Product(id = 4), quantity = 7, purchaseOrder = PurchaseOrder(id = 4),
                    value = BigDecimal.valueOf(3837.44)))

            add(ItemOrder(id = 0, product = Product(id = 5), quantity = 9, purchaseOrder = PurchaseOrder(id = 4),
                    value = BigDecimal.valueOf(5690.44)))
        }
        itemRepository.saveAll(list)
    }*/
}