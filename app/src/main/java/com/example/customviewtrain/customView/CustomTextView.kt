package com.example.customviewtrain.customView

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.util.AttributeSet
import androidx.appcompat.widget.AppCompatTextView

class CustomTextView(context: Context,attr: AttributeSet) : AppCompatTextView(context,attr){

    private var backgroundPaint = Paint().apply {
        color = Color.RED
        style = Paint.Style.FILL
    }

    override fun onDraw(canvas: Canvas?) {
        canvas?.drawRect(0F, 0F,width.toFloat(),height.toFloat(),backgroundPaint)
        super.onDraw(canvas)
    }
}