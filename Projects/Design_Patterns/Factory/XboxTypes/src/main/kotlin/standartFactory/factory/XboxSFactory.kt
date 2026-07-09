package standartFactory.factory

import standartFactory.model.Xbox
import standartFactory.model.XboxS

class XboxSFactory : XboxFactory() {

    override fun createXbox(): Xbox {
        return XboxS()
    }
}