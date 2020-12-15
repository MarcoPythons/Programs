using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;


using OnBrakeDatos;

namespace OnBrakeNegocio
{
    public class CommonBC
    {
        

            public CommonBC()
            {

            }

            private static OnBreak2Entities modeloDB;

            public static OnBreak2Entities ModeloOnbrake
            {

                get
                {
                    if (modeloDB == null)
                    {
                        modeloDB = new OnBreak2Entities();
                    }
                    return modeloDB;
                }
            }




        }

    
}
