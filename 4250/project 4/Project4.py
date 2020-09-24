class Product:
    def __init__(self, name, price, discountPercent):
        self.__name = name
        self.__price = price
        self.__discountPercent = discountPercent
    def getDiscountAmount(self):
        return self.__price * self.__discountPercent
    def getDiscountPrice(self):
        return self.__price - self.getDiscountAmount()
    def printDescription(self):
        return "Name: " + self.__name + "" + ", Price: " + str(self.__price) + ", Discount Percent: " + str(self.__discountPercent) + ", Discount Amount: " + str(self.getDiscountAmount()) + ", Discount Price: " + str(self.getDiscountPrice())

class Book(Product):
    def __init__(self, author, name, price, discountPercent):
        self.__author = author
        Product.__init__(self, name, price, discountPercent)
    def printDescription(self):
        return "Author: " + self.__author + ", " + Product.printDescription(self)
class Movie(Product):
    def __init__(self, year, name, price, discountPercent):
        self.__year = year
        Product.__init__(self, name, price, discountPercent)
    def printDescription(self):
        return "Year: " + str(self.__year) + ", " + Product.printDescription(self)

product = Product("Yeet", 10, 0.1)
book = Book("Brandon London", "Yeeted", 12, 0.5)
movie = Movie(2019, "Yeeter", 100, 0.2)

print(product.printDescription())
print(book.printDescription())
print(movie.printDescription())