package com.example.customviewtrain.customView

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.util.AttributeSet
import android.view.View
import com.example.customviewtrain.R
import kotlin.math.min

class Rectangle(context: Context, attr: AttributeSet) : View(context, attr) {
    private val backgroundPaint = Paint().apply {
        color = Color.CYAN
        style = Paint.Style.FILL
    }

    private val fillColor: Int

    init {
        val ta = context.theme.obtainStyledAttributes(attr, R.styleable.Rectangle,0,0)
        try {
            fillColor = ta.getColor(R.styleable.Rectangle_fillColor,1)
        } finally {
            ta.recycle()
        }
    }

    override fun onDraw(canvas: Canvas?) {
        canvas?.drawRect(0f, 0f, width.toFloat(), height.toFloat(), backgroundPaint)
        super.onDraw(canvas)
    }

    private fun getMeasurementSize(measureSpec: Int, defaultSize: Int): Int {
        val mode = MeasureSpec.getMode(measureSpec)
        val size = MeasureSpec.getSize(measureSpec)
        return when (mode) {
            MeasureSpec.EXACTLY -> size
            MeasureSpec.AT_MOST -> min(defaultSize, size)
            MeasureSpec.UNSPECIFIED -> defaultSize
            else -> defaultSize
        }
    }

    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        val width = getMeasurementSize(widthMeasureSpec, DEFAULT_BUFFER_SIZE)
        val height = getMeasurementSize(
            heightMeasureSpec,
            DEFAULT_BUFFER_SIZE
        )
        setMeasuredDimension(width, height)
    }
}