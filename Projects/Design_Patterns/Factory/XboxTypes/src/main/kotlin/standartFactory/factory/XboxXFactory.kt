package standartFactory.factory

import standartFactory.model.Xbox
import standartFactory.model.XboxS
import standartFactory.model.XboxX

class XboxXFactory : XboxFactory() {

    override fun createXbox(): Xbox {
        return XboxX()
    }
}