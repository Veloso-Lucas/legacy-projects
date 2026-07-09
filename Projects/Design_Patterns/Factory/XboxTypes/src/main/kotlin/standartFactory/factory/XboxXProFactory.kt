package standartFactory.factory

import standartFactory.model.Xbox
import standartFactory.model.XboxS
import standartFactory.model.XboxX
import standartFactory.model.XboxXPro

class XboxXProFactory : XboxFactory() {

    override fun createXbox(): Xbox {
        return XboxXPro()
    }
}