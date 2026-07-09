package standartFactory.model

class XboxXPro : Xbox() {

    override fun getHardware() {
        println("Hardware list")
        println("\t- 32 GB RAM")
        println("\t- AMD 8x Zen 3 @ 4.7GHz (4.3GHz With SMT)")
        println("\t- 2TB Memory")
    }
}