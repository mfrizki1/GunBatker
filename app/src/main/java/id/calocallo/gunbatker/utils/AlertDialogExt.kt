package id.calocallo.gunbatker.utils

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.annotation.StringRes
import androidx.appcompat.app.AlertDialog
import id.calocallo.gunbatker.R

inline fun Context.alert(result: CharSequence? = null,func: AlertDialogHelper.() -> Unit): AlertDialog {
    return AlertDialogHelper(this, result).apply {
        func()
    }.create()
}

class AlertDialogHelper(context: Context, result: CharSequence?){
    private val dialogView: View by lazyFast {
        LayoutInflater.from(context).inflate(R.layout.layout_result_dialog, null)
    }

    private val builder: AlertDialog.Builder = AlertDialog.Builder(context)
        .setView(dialogView)

    private val title: TextView by lazyFast {
        dialogView.findViewById<TextView>(R.id.txt_title_dialog)
    }

    private val message: TextView by lazyFast {
        dialogView.findViewById<TextView>(R.id.txt_result_dialog)
    }

    private val positiveButton: Button by lazyFast {
        dialogView.findViewById<Button>(R.id.btn_play_again_dialog)
    }

    private val negativeButton: Button by lazyFast {
        dialogView.findViewById<Button>(R.id.btn_back_home_dialog)
    }

    private var dialog: AlertDialog? = null

    var cancelable: Boolean = true

    init {
//        this.title.text = title
        this.message.text = result
    }

    fun positiveButton(@StringRes textResource: Int, func: (() -> Unit)? = null) {
        with(positiveButton) {
            text = builder.context.getString(textResource)
            setClickListenerToDialogButton(func)
        }
    }

    fun positiveButton(text: CharSequence, func: (() -> Unit)? = null) {
        with(positiveButton) {
            this.text = text
            setClickListenerToDialogButton(func)
        }
    }

    fun positiveButton(func: (() -> Unit)? = null) {
        with(positiveButton) {
            setClickListenerToDialogButton(func)
        }
    }

    fun negativeButton(@StringRes textResource: Int, func: (() -> Unit)? = null) {
        with(negativeButton) {
            text = builder.context.getString(textResource)
            setClickListenerToDialogButton(func)
        }
    }

    fun negativeButton(text: CharSequence, func: (() -> Unit)? = null) {
        with(negativeButton) {
            this.text = text
            setClickListenerToDialogButton(func)
        }
    }
    fun negativeButton(func: (() -> Unit)? = null) {
        with(negativeButton) {
            setClickListenerToDialogButton(func)
        }
    }

    fun onCancel(func: () -> Unit) {
        builder.setOnCancelListener { func() }
    }

    fun create(): AlertDialog {
        title.goneIfTextEmpty()
        message.goneIfTextEmpty()
        positiveButton.goneIfTextEmpty()
        negativeButton.goneIfTextEmpty()

        dialog = builder
            .setCancelable(cancelable)
            .create()
        return dialog!!
    }

    private fun TextView.goneIfTextEmpty() {
        visibility = if (text.isNullOrEmpty()) {
            View.GONE
        } else {
            View.VISIBLE
        }
    }

    private fun Button.setClickListenerToDialogButton(func: (() -> Unit)?) {
        setOnClickListener {
            func?.invoke()
            dialog?.dismiss()
        }
    }
}