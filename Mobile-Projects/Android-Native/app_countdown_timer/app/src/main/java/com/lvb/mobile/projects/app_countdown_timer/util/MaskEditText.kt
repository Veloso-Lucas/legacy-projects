package com.lvb.mobile.projects.app_countdown_timer.util

import android.text.Editable
import android.text.TextWatcher
import android.widget.EditText


class MaskEditText {

    companion object {

        const val FORMAT_CPF = "###.###.###-##"
        const val FORMAT_PHONE = "(###)####-#####"
        const val FORMAT_CEP = "#####-###"
        const val FORMAT_DATE = "##/##/####"
        const val FORMAT_HOUR = "##:##"

        fun mask(ediTxt: EditText, mask: String): TextWatcher {
            return object : TextWatcher {
                var isUpdating = false
                var old = ""

                override fun afterTextChanged(s: Editable) {}

                override fun beforeTextChanged(
                    s: CharSequence,
                    start: Int,
                    count: Int,
                    after: Int
                ) {
                    val str: String = unmask(s.toString())
                }

                override fun onTextChanged(s: CharSequence, start: Int, before: Int, count: Int) {
                    val str: String = unmask(s.toString())
                    var mascara = ""
                    if (isUpdating) {
                        old = str
                        isUpdating = false
                        return
                    }
                    var i = 0
                    for (m in mask.toCharArray()) {
                        if (m != '#' && str.length > old.length) {
                            mascara += m
                            continue
                        }
                        mascara += try {
                            str[i]
                        } catch (e: Exception) {
                            break
                        }
                        i++
                    }
                    isUpdating = true
                    ediTxt.setText(mascara)
                    ediTxt.setSelection(mascara.length)
                }
            }
        }


        fun unmask(s: String?): String {
            val str = s?.replace("[.]".toRegex(), "")?.replace("[-]".toRegex(), "")
                ?.replace("[/]".toRegex(), "")?.replace("[(]".toRegex(), "")
                ?.replace("[ ]".toRegex(), "")?.replace("[:]".toRegex(), "")
                ?.replace("[)]".toRegex(), "")

            return str ?: ""
        }
    }
}