#include "todowindow.h"
#include "ui_todowindow.h"

TodoWindow::TodoWindow(QWidget *parent) :
    QWidget(parent),
    ui(new Ui::TodoWindow)
{
    ui->setupUi(this);
}

TodoWindow::~TodoWindow()
{
    delete ui;
}

void TodoWindow::on_savepushButton_clicked()
{
    QTableWidgetItem *project = new QTableWidgetItem();
    QTableWidgetItem *text = new QTableWidgetItem();
    QTableWidgetItem *reminder = new QTableWidgetItem();

    project->setText(ui->projectnamelineEdit->text());
    text->setText(ui->textlineEdit->text());
    reminder->setText(ui->reminderlineEdit->text());

    int insertRow = ui->tableWidget->rowCount();
    ui->tableWidget->insertRow(insertRow);

    ui->tableWidget->setItem(insertRow, 1, project);
    ui->tableWidget->setItem(project->row(), 2, text);
    ui->tableWidget->setItem(text->row(), 3, reminder);
}

void TodoWindow::on_deletepushButton_clicked()
{
    ui->tableWidget->removeRow(ui->tableWidget->currentRow());
}

void TodoWindow::on_updatepushButton_clicked()
{
    QString project = ui->projectnamelineEdit->text();
    QString text = ui->textlineEdit->text();
    QString reminder = ui->reminderlineEdit->text();

    int currentRow = ui->tableWidget->currentRow();

    ui->tableWidget->item(currentRow, 1)->setText(project);
    ui->tableWidget->item(currentRow, 2)->setText(text);
    ui->tableWidget->item(currentRow, 3)->setText(reminder);
}

void TodoWindow::on_tableWidget_clicked(const QModelIndex &index)
{
    int row = index.row();

    ui->projectnamelineEdit->setText(index.sibling(row, 1).data().toString());
    ui->textlineEdit->setText(index.sibling(row, 2).data().toString());
    ui->reminderlineEdit->setText(index.sibling(row, 3).data().toString());
}
