package standartFactory.factory

import standartFactory.model.Xbox

abstract class XboxFactory {

    fun orderXbox() : Xbox {

        val xbox = createXbox()

        xbox.getHardware()
        xbox.assemble()
        xbox.certificates()
        xbox.pack()

        return xbox
    }

    protected abstract fun createXbox() : Xbox
}