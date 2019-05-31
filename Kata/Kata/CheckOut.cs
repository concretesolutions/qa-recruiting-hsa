using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Kata
{
    public class CheckOut
    {
        PricingRules pricingRules;
        Dictionary<string, int> items;

        public CheckOut(PricingRules pricingRules)
        {
            this.items = new Dictionary<string, int>();
            this.pricingRules = pricingRules;
        }

        public void Scan(string item)
        {
            if (items.ContainsKey(item)) items[item]++;
            else items.Add(item, 1);
        }

        public void ScanMultiple(string items)
        {
            foreach (var item in items.Split(','))
            {
                Scan(item);
            }
        }

        public int Total()
        {
            int total = 0;

            foreach (var item in items)
            {
                if (pricingRules.pricingList.ContainsKey(item.Key))
                {
                    Rule rule = pricingRules.pricingList[item.Key];
                    if (item.Value < rule.specialPriceCont)
                        total += item.Value * rule.price;
                    else
                    {
                        if (rule.specialPriceCont != 0)
                        {
                            int quotient = item.Value / rule.specialPriceCont;
                            int remainder = item.Value % rule.specialPriceCont;
                            total += rule.specialPrice * quotient + remainder * rule.price;
                        }
                        else total += item.Value * rule.price;
                    }
                }
                else throw new ItemNotFoundException();
            }
            return total;
        }
    }
}
