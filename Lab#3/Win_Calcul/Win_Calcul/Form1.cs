using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace Win_Calcul
{
    public partial class Form1 : Form
    {
     
        bool znak = true;
        double value = 0;
        String operation = "";
        bool operation_pressed = false;

        public Form1()
        {
            InitializeComponent();
        }

        private void Form1_Load(object sender, EventArgs e)
        {

        }

        private void textBox1_TextChanged(object sender, EventArgs e)
        {

        }

        private void button_Click(object sender, EventArgs e)
        {
            if ((result.Text == "0")||(operation_pressed))
                result.Clear();
            operation_pressed = false;

            Button b = (Button)sender;
            if (b.Text == ",")
            {
                if (!result.Text.Contains(","))
                    result.Text = result.Text + b.Text;
            }
            else
            result.Text = result.Text + b.Text;
            
        }

        private void button18_Click(object sender, EventArgs e)
        {
            result.Text = "0";
            
        }

        private void operator_click(object sender, EventArgs e)
        {
            Button b = (Button)sender;

            if (value != 0)
            {
                if (b.Text == "sqrt")
                    result.Text = Operators.Sqrt(double.Parse(result.Text)).ToString();
                //  equal.PerformClick();
                operation_pressed = true;
                operation = b.Text;
              //  equation.Text = value + "" + operation;
            }
            else if (b.Text == "sqrt")
            {
                result.Text = Operators.Sqrt(double.Parse(result.Text)).ToString();
                value = Math.Sqrt(double.Parse(result.Text));
            }
           
            else {

                operation = b.Text;
                value = Convert.ToDouble(result.Text);
                operation_pressed = true;
               // equation.Text = value + "" + operation;
            }
            

            }

        private void button16_Click(object sender, EventArgs e)
        {
            switch (operation)
            {
                
                case "+":
                    //result.Text =(value + Double.Parse(result.Text)).ToString();
                    result.Text = Operators.Add(value , double.Parse(result.Text)).ToString();
                    break;
                case "-":
                    //result.Text = (value - Double.Parse(result.Text)).ToString();
                    result.Text = Operators.Sub(value, double.Parse(result.Text)).ToString();
                    break;
                case "*":
                    // result.Text = (value * Double.Parse(result.Text)).ToString();
                    result.Text = Operators.Mult(value, double.Parse(result.Text)).ToString();
                    break;
                case "/":
                    // result.Text = (value / Double.Parse(result.Text)).ToString();
                    result.Text = Operators.Div(value , double.Parse(result.Text)).ToString();
                    break;
                case "^": //любой значок приделай
                    result.Text = Math.Pow(value, double.Parse(result.Text)).ToString();
                    break;
                
                default:
                    break;


            }//конец switch
            value = Convert.ToDouble(result.Text);
            operation = "";
        }

        private void button17_Click(object sender, EventArgs e)
        {
            result.Text = "0";
            value = 0;
        }

        private void button19_Click(object sender, EventArgs e)
        {
            if (znak == true)
            {
                result.Text = "-" + result.Text;
                znak = false;
            }
            else if (znak == false)
            {
                result.Text = result.Text.Replace("-", "");
                znak = true;
            }
            }
    }
}
