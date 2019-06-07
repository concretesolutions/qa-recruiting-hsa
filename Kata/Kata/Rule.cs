using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Kata
{
    public class Rule
    {

        public string item { get; set;}
        public int price { get; set; }
        public int specialPriceCont { get; set; }
        public int specialPrice { get; set; }

        public Rule(string item, int price, int specialPriceCont, int specialPrice)
        {
            this.item = item;
            this.price = price;
            this.specialPriceCont = specialPriceCont;
            this.specialPrice = specialPrice;
        }
    }
}
