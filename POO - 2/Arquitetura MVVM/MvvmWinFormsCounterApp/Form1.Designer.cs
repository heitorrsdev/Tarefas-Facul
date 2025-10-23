namespace MvvmWinFormsCounterApp
{
    partial class Form1
    {
        private System.ComponentModel.IContainer components = null;

        protected override void Dispose(bool disposing)
        {
            if (disposing && (components != null))
            {
                components.Dispose();
            }
            base.Dispose(disposing);
        }

        #region Windows Form Designer generated code

        private void InitializeComponent()
        {
            this.countLabel = new System.Windows.Forms.Label();
            this.incrementButton = new System.Windows.Forms.Button();
            this.decrementButton = new System.Windows.Forms.Button();
            this.resetButton = new System.Windows.Forms.Button();
            this.SuspendLayout();
            // 
            // countLabel
            // 
            this.countLabel.Font = new System.Drawing.Font("Segoe UI", 24F, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point);
            this.countLabel.Location = new System.Drawing.Point(12, 9);
            this.countLabel.Name = "countLabel";
            this.countLabel.Size = new System.Drawing.Size(260, 50);
            this.countLabel.TabIndex = 0;
            this.countLabel.Text = "0";
            this.countLabel.TextAlign = System.Drawing.ContentAlignment.MiddleCenter;
            // 
            // incrementButton
            // 
            this.incrementButton.Location = new System.Drawing.Point(12, 75);
            this.incrementButton.Name = "incrementButton";
            this.incrementButton.Size = new System.Drawing.Size(80, 30);
            this.incrementButton.TabIndex = 1;
            this.incrementButton.Text = "Aumentar";
            this.incrementButton.UseVisualStyleBackColor = true;
            // 
            // decrementButton
            // 
            this.decrementButton.Location = new System.Drawing.Point(98, 75);
            this.decrementButton.Name = "decrementButton";
            this.decrementButton.Size = new System.Drawing.Size(80, 30);
            this.decrementButton.TabIndex = 2;
            this.decrementButton.Text = "Diminuir";
            this.decrementButton.UseVisualStyleBackColor = true;
            // 
            // resetButton
            // 
            this.resetButton.Location = new System.Drawing.Point(184, 75);
            this.resetButton.Name = "resetButton";
            this.resetButton.Size = new System.Drawing.Size(80, 30);
            this.resetButton.TabIndex = 3;
            this.resetButton.Text = "Zerar";
            this.resetButton.UseVisualStyleBackColor = true;
            // 
            // Form1
            // 
            this.AutoScaleDimensions = new System.Drawing.SizeF(7F, 15F);
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.ClientSize = new System.Drawing.Size(284, 121);
            this.Controls.Add(this.resetButton);
            this.Controls.Add(this.decrementButton);
            this.Controls.Add(this.incrementButton);
            this.Controls.Add(this.countLabel);
            this.Name = "Form1";
            this.Text = "Contador MVVM";
            this.ResumeLayout(false);

        }

        #endregion

        private System.Windows.Forms.Label countLabel;
        private System.Windows.Forms.Button incrementButton;
        private System.Windows.Forms.Button decrementButton;
        private System.Windows.Forms.Button resetButton;
    }
}
