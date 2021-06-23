using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;


using Controlador;

namespace Modelo
{
    public class ComonBC
    {
        public ComonBC()
        {

        }
        private static ModeloOracle modeloBD;

        public static ModeloOracle oradata
        {
            get
            {
                if (modeloBD == null)
                {
                    modeloBD = new ModeloOracle();
                }
                return modeloBD;
            }
        }


    }
}
