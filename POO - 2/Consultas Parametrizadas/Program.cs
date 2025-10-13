using System;
using Microsoft.Data.Sqlite;
using Dapper;
using System.Data.SQLite;

class Program
{
    static void Main()
    {
        using var connection = new SqliteConnection("Data Source=:memory:");
        connection.Open();

        string createTable = @"
            CREATE TABLE Products (
                Id INTEGER PRIMARY KEY AUTOINCREMENT,
                ProductName TEXT NOT NULL,
                Price REAL NOT NULL
            );";
        connection.Execute(createTable);

        var products = new[]
        {
            new { ProductName = "Maçã", Price = 1.20 },
            new { ProductName = "Banana", Price = 0.80 },
            new { ProductName = "Laranja", Price = 1.00 },
            new { ProductName = "Abacaxi", Price = 2.50 }
        };

        foreach (var p in products)
        {
            connection.Execute("INSERT INTO Products (ProductName, Price) VALUES (@ProductName, @Price)", p);
        }

        int searchPrice = 1;

        var result = connection.Query<Product>(
            "SELECT ProductName, Price FROM Products WHERE Price > @Preco",
            new { Preco = searchPrice });

        foreach (var prod in result)
        {
            Console.WriteLine($"Produto: {prod.ProductName} - Preço: {prod.Price:C}");
        }
    }
}

class Product
{
    public string ProductName { get; set; }
    public double Price { get; set; }
}
