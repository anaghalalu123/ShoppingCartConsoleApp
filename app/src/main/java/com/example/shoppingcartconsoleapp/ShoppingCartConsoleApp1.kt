package com.example.shoppingcartconsoleapp

fun main() {
    val products = mapOf(
        1 to "Apple",
        2 to "Banana",
        3 to "Milk",
        4 to "Bread",
        5 to "Eggs"
    )

    val cart = mutableListOf<String>()

    while (true) {
        println(
            """|---Shopping Cart Menu---
               |1.View Product
               |2.Add to Cart
               |3.View Cart
               |4.Remove Item from cart
               |5.Exit
        
        """.trimMargin()
        )

        println("Choose an option(1 -5): ")
        when (readLine()?.toIntOrNull()) {

            1 -> {
                println("---Available products---")
                for ((id, name) in products) {
                    println("$id.$name")
                }
            }

            2 -> {
                println("Enter product ID of the item to add in cart:")
                val id = readLine()?.toIntOrNull()
                val item = products[id]
                if (item != null) {
                    cart.add(item)
                    println("$item added to cart")
                } else {
                    println("Invalid product id")
                }
            }

            3 -> {
                println("---Your Cart ---")
                if (cart.isEmpty()) {
                    println("Your cart is empty")
                } else {
                    cart.forEachIndexed { index, item ->// to view the items in cart
                        println("${index + 1}.$item")// we are using (index+1 )because human expects numbers starting from 1 but not zero, they wont understand zero based indexing in code
                    }

                }
            }

            4 -> {
                println("---Remove item from cart---")
                cart.forEachIndexed { index, item ->
                    println("${index + 1}.$item")
                }
                println("Enter item number to remove: ")
                val removeIndex = readLine()?.toIntOrNull()
                if (removeIndex != null && removeIndex in 1..cart.size) {
                    val removedItem = cart.removeAt(removeIndex - 1)
                    println("$removedItem removed from cart.")
                } else {
                    println("Invalid item number, Try again")
                }
            }

            5 -> {
                println("Thanks for shopping")
                break
            }

            else -> {
                println("Invalid option, Try again")
            }
        }

    }
}
