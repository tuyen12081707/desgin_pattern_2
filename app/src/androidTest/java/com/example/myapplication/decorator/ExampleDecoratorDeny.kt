package com.example.myapplication.decorator

// Lớp cơ bản hiển thị văn bản
class ExampleDecoratorDeny{
    open class TextView {
        open fun render(): String = "Text"
    }

    open class BoldTextView : TextView() {
        override fun render(): String = "**${super.render()}**"
    }

    open class ItalicBoldTextView : BoldTextView() {
        override fun render(): String = "_${super.render()}_"
    }

    class UnderlineItalicBoldTextView : ItalicBoldTextView() {
        override fun render(): String = "__${super.render()}__"
    }


    fun main() {
        val textView = UnderlineItalicBoldTextView()
        println(textView.render())
        //  se in ra: __**_Text_**__
    }
}
class DecoratorPattern{
    // 1. Component (Giao diện chung)
    interface TextView {
        fun render(): String
    }

    // 2. Concrete Component (Lớp cốt lõi)
    class SimpleTextView : TextView {
        override fun render(): String = "Text"
    }

    // 3. Decorator (Lớp trang trí trừu tượng)
    abstract class TextViewDecorator(private val textView: TextView) : TextView {
        override fun render(): String = textView.render()
    }

    // 4. Concrete Decorators (Các lớp trang trí cụ thể)
    class BoldDecorator(textView: TextView) : TextViewDecorator(textView) {
        override fun render(): String = "**${super.render()}**"
    }

    class ItalicDecorator(textView: TextView) : TextViewDecorator(textView) {
        override fun render(): String = "_${super.render()}_"
    }

    class UnderlineDecorator(textView: TextView) : TextViewDecorator(textView) {
        override fun render(): String = "__${super.render()}__"
    }

    fun main() {
        // Lớp cơ bản
        val simpleText = SimpleTextView()

        val boldText = BoldDecorator(simpleText)
        println(boldText.render()) // Output: **Text**

        val italicBoldText = ItalicDecorator(boldText)
        println(italicBoldText.render()) // Output: _**Text**_

        val underlineItalicBoldText = UnderlineDecorator(italicBoldText)
        println(underlineItalicBoldText.render()) // Output: __**_Text_**__
    }


}


