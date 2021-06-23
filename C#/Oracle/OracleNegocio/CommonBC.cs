using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;


using ADO.Conn;

namespace OracleNegocio
{
    public class CommonBC
    {

        public CommonBC()
        {

        }


        private static Oradata modeloDB;

        public static Oradata ModeloOracle
        {
            get
            {
                if (modeloDB == null)
                {
                    modeloDB = new Oradata();
                }
                return modeloDB;
            }
        }
    }

}
