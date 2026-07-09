package standartFactory.model

class XboxS: Xbox() {

    override fun getHardware() {
        println("Hardware list")
        println("\t- 10 GB RAM")
        println("\t- AMD octa-core")
        println("\t- 512Gb Memory")
    }

}