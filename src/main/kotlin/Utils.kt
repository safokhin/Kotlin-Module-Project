import java.util.Scanner


/** Отображение и выбор пункта меню. Возвращает индекс выбора */
fun showMenu(nameList: List<String>, title: String = "-----\nВыберите пункт:\n-----"): Int {
    val scanner = Scanner(System.`in`)

    while (true) {
        // Вывод списка
        println(title)
        for((index, item) in nameList.withIndex()) {
            println("${index + 1}. $item")
        }

        val userIndex = getIntScanner(scanner) - 1

        if (isArrayItem(nameList, userIndex)) {
            return userIndex
        } else {
            println("Такого пункта не существует, попробуйте еще раз")
        }
    }
}


/** Получение числа из ввода пользователя */
fun getIntScanner(scanner: Scanner): Int {
    return try {
        scanner.nextInt()
    } catch (e: Exception) {
        scanner.nextLine()
        println("Введите число")
        getIntScanner(scanner)
    }
}

/** Проверка на наличие элемента по индексу */
fun isArrayItem(list: List<Any?>, index: Int): Boolean {
    return index >= 0 && index < list.size
}