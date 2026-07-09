package standartFactory.model

abstract class Xbox {

    abstract fun getHardware()

    fun assemble() {
        println("Assembling all the hardwares")
    }

    fun certificates() {
        println("Testing all the certificates")
    }

    fun pack() {
        println("Packing the device")
    }
}