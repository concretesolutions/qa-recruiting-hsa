using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Kata
{
    public class PricingRules
    {
        public Dictionary<string, Rule> pricingList { get; set; }

        public PricingRules()
        {
            this.pricingList = new Dictionary<string, Rule> ();
            createList();
        }
        private void createList()
        {
            Rule r1 = new Rule("A", 50, 3, 130);
            Rule r2 = new Rule("B", 30, 2, 45);
            Rule r3 = new Rule("C", 20, 0, 0);
            Rule r4 = new Rule("D", 15, 0, 0);

            pricingList.Add(r1.item, r1);
            pricingList.Add(r2.item, r2);
            pricingList.Add(r3.item, r3);
            pricingList.Add(r4.item, r4);
        }
    }
}
