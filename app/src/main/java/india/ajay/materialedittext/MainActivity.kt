package india.ajay.materialedittext

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.design.widget.TextInputLayout
import android.support.v7.widget.AppCompatEditText
import android.text.Editable
import android.text.TextWatcher
import android.view.View
import android.widget.RelativeLayout

class MainActivity : AppCompatActivity() {

    private var userNameAppCompatEditText: AppCompatEditText? = null
    private var passwordAppCompatEditText: AppCompatEditText? = null
    private var userInputLayout: TextInputLayout? = null
    private var passwordInputLayout: TextInputLayout? = null
    private var parentLayout: RelativeLayout? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setupView()
    }

    private fun setupView() {
        parentLayout = findViewById(R.id.parent_layout)
        userNameAppCompatEditText = findViewById(R.id.username_edit_text)
        passwordAppCompatEditText = findViewById(R.id.password_edit_text)
        userInputLayout = findViewById(R.id.username_text_input_layout)
        passwordInputLayout = findViewById(R.id.password_text_input_layout)
        parentLayout?.setOnClickListener(null)
        userNameAppCompatEditText?.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(p0: Editable?) {
            }

            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
            }

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                if(userNameAppCompatEditText?.text.toString().isEmpty()){
                    userInputLayout?.isErrorEnabled = true
                    userInputLayout?.error = getString(R.string.enter_username)
                } else {
                    userInputLayout?.isErrorEnabled = false
                }
            }
        })

        userNameAppCompatEditText?.onFocusChangeListener = View.OnFocusChangeListener { v, hasFocus ->
            if(userNameAppCompatEditText?.text.toString().isEmpty()){
                userInputLayout?.isErrorEnabled = true
                userInputLayout?.error = getString(R.string.enter_username)
            } else {
                userInputLayout?.isErrorEnabled = false
            }
        }
        passwordInputLayout?.isCounterEnabled = true
        passwordInputLayout?.counterMaxLength = 20

    }
}
