package com.app.rhombus

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.app.rhombus.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        initAction()
    }

    private fun initAction() {
        binding.btnSubmit.setOnClickListener {
            val value = binding.etValue.text.toString()
            if (value.isEmpty()){
                toast("Value cannot be empty")
            } else {
                val initValue = value.toInt();
                when {
                    initValue < 5 -> {
                        toast("Number between 5 - 100")
                    }
                    initValue > 100 -> {
                        toast("Number between 5 - 100")
                    }
                    else -> binding.tvResult.text = calculate(initValue)
                }
            }
        }
    }

    private fun calculate(star: Int): String {
        val stringBuilder = StringBuilder()
        var space = 0
        for (i in 0 until star / 2) {
            if (i == 0 || i == star - 1) {
                if (star % 2 == 1) {
                    stringBuilder.append("*")
                } else {
                    stringBuilder.append("**")
                }
            } else {
                stringBuilder.append("*")
            }
            if (space > 0) {
                stringBuilder.append(" ".repeat(space))
                stringBuilder.append("*")
            }
            stringBuilder.append(System.getProperty("line.separator"))
            space++

        }

        if (star % 2 == 0) {
            space--
        }

        for (i in star / 2 until star) {
            if (i == star - 1) {
                if (star % 2 == 1) {
                    stringBuilder.append("*")
                } else {
                    stringBuilder.append("**")
                }
            } else {
                stringBuilder.append("*")
            }

            if (space > 0) {
                stringBuilder.append(" ".repeat(space))
                stringBuilder.append("*")
            }
            stringBuilder.append(System.getProperty("line.separator"))
            space--
        }
        return stringBuilder.toString()
    }
}