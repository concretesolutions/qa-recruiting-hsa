using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Kata
{
    public class ItemNotFoundException:ApplicationException
    {
        public ItemNotFoundException():base(message: "Item not found")
        {
        }
    }
}

