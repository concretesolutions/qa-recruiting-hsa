using System;
using Microsoft.VisualStudio.TestTools.UnitTesting;
using Kata;
using System.Collections.Generic;

namespace KataUnitTest
{
    [TestClass]
    public class TestPrice
    {
        [TestMethod]
        public void ScanMultipleTest()
        {
            PricingRules pricingRules = new PricingRules();
            CheckOut checkOut = new CheckOut(pricingRules);
            checkOut.ScanMultiple("A,B,C,D,A,D");
            Assert.AreEqual(180,checkOut.Total());
        }

        [TestMethod]
        [ExpectedException(typeof(ItemNotFoundException))]
        public void ScanMultipleIncorrectItem()
        {
            PricingRules pricingRules = new PricingRules();
            CheckOut checkOut = new CheckOut(pricingRules);
            checkOut.ScanMultiple("A,1,C,D,A,D");
            checkOut.Total();
        }

        [TestMethod]
        public void ScanTest()
        {
            PricingRules pricingRules = new PricingRules();
            CheckOut checkOut = new CheckOut(pricingRules);
            checkOut.Scan("A");
            checkOut.Scan("A");
            checkOut.Scan("B");
            checkOut.Scan("B");
            Assert.AreEqual(145, checkOut.Total());
        }

        [TestMethod]
        public void NewPricingListTest()
        {
            PricingRules pricingRules = new PricingRules();
            pricingRules.pricingList = new Dictionary<string, Rule>();

            pricingRules.pricingList.Add("E", new Rule("E", 25, 2, 46));
            pricingRules.pricingList.Add("F", new Rule("F", 50, 3, 140));
            pricingRules.pricingList.Add("G", new Rule("G", 10, 0, 0));
            CheckOut checkOut = new CheckOut(pricingRules);

            checkOut.Scan("E");
            checkOut.Scan("F");
            checkOut.Scan("F");
            checkOut.Scan("F");
            checkOut.Scan("G");

            Assert.AreEqual(175, checkOut.Total());
        }


    }
}
