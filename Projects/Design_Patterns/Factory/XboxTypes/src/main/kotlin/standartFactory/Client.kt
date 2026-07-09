package standartFactory

import standartFactory.factory.XboxFactory
import standartFactory.factory.XboxSFactory
import standartFactory.factory.XboxXFactory
import standartFactory.factory.XboxXProFactory
import standartFactory.model.Xbox

class Client {

    fun main(args: Array<String>) {

        val factoryS : XboxFactory = XboxSFactory()
        val factoryX : XboxFactory = XboxXFactory()
        val factoryXPro : XboxFactory = XboxXProFactory()


        val xboxS : Xbox = factoryS.orderXbox()
        val xboxX : Xbox = factoryX.orderXbox()
        val xboxXPro : Xbox = factoryXPro.orderXbox()


        println("### Ordering an Xbox S")
        println(xboxS)
        println("\n\n###")

        println("### Ordering an Xbox X")
        println(xboxX)
        println("\n\n###")

        println("### Ordering an Xbox XPro")
        println(xboxXPro)
        println("\n\n###")


    }
}