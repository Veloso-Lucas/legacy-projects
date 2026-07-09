package standartFactory.model

class XboxX: Xbox() {

    override fun getHardware() {
        println("Hardware list")
        println("\t- 16 GB RAM")
        println("\t- AMD 8x Zen 2 @ 3.8GHz (3.6GHz With SMT)")
        println("\t- 1TB Memory")
    }
}