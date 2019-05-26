using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Kata
{
    class Program
    {
        static void Main(string[] args)
        {
            PricingRules pricingRules = new PricingRules();

            Console.WriteLine("============>Stating execution <============");
            Console.WriteLine("Pricing table");
            Console.WriteLine("Item | Unit Price | Special Price");
            foreach (var item in pricingRules.pricingList)
            {
                Console.WriteLine(item.Key + "    |" + item.Value.price + "          |" + item.Value.specialPriceCont + " for " +  item.Value.specialPrice);
            }
            CheckOut checkOut = new CheckOut(pricingRules);
            Console.WriteLine();
            Console.WriteLine("Scaning products");

            Console.WriteLine("A");
            checkOut.Scan("A");

            Console.WriteLine("B");
            checkOut.Scan("B");

            Console.WriteLine("A");
            checkOut.Scan("A");

            Console.WriteLine("A");
            checkOut.Scan("A");

            Console.WriteLine("Total price : " + checkOut.Total());
            Console.ReadLine();
        }
    }
}
