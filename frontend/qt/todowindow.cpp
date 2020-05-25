#include "todowindow.h"
#include "ui_todowindow.h"
#include "mainwindow.h"

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

}

void TodoWindow::on_deletepushButton_clicked()
{
}

void TodoWindow::on_updatepushButton_clicked()
{

}

void TodoWindow::on_tableWidget_clicked(const QModelIndex &index)
{
    int row = index.row();

    ui->projectnamelineEdit->setText(index.sibling(row, 1).data().toString());
    ui->textlineEdit->setText(index.sibling(row, 2).data().toString());
//    ui->reminderlineEdit->setText(index.sibling(row, 3).data().toString());
}

void TodoWindow::on_signOutpushButton_clicked()
{
    this->destroy();
}

void TodoWindow::on_projectSavepushButton_clicked()
{
    QTableWidgetItem *project = new QTableWidgetItem();
    QTableWidgetItem *text = new QTableWidgetItem();

    project->setText(ui->projectnamelineEdit->text());
    text->setText(ui->textlineEdit->text());

    int insertRow = ui->tableWidget->rowCount();
    ui->tableWidget->insertRow(insertRow);

    ui->tableWidget->setItem(insertRow, 1, project);
    ui->tableWidget->setItem(project->row(), 2, text);
}

void TodoWindow::on_projectUpdatepushButton_clicked()
{
    QString project = ui->projectnamelineEdit->text();
    QString text = ui->textlineEdit->text();

    int currentRow = ui->tableWidget->currentRow();

    ui->tableWidget->item(currentRow, 1)->setText(project);
    ui->tableWidget->item(currentRow, 2)->setText(text);
}

void TodoWindow::on_projectDeletepushButton_clicked()
{
    ui->tableWidget->removeRow(ui->tableWidget->currentRow());
}

void TodoWindow::on_labelSavepushButton_clicked()
{
    QTableWidgetItem *name = new QTableWidgetItem();

    name->setText(ui->labelnamelineEdit->text());

    int insertRow = ui->tableWidget_2->rowCount();
    ui->tableWidget_2->insertRow(insertRow);

    ui->tableWidget_2->setItem(insertRow, 1, name);
}

void TodoWindow::on_labelUpdatepushButton_clicked()
{
    QString name = ui->labelnamelineEdit->text();

    int currentRow = ui->tableWidget_2->currentRow();

    ui->tableWidget_2->item(currentRow, 1)->setText(name);
}

void TodoWindow::on_labelDeletepushButton_clicked()
{
    ui->tableWidget_2->removeRow(ui->tableWidget_2->currentRow());

}

void TodoWindow::on_taskSavepushButton_clicked()
{
    QTableWidgetItem *name = new QTableWidgetItem();
    QTableWidgetItem *desc = new QTableWidgetItem();
    QTableWidgetItem *deadline = new QTableWidgetItem();
    QTableWidgetItem *project = new QTableWidgetItem();
    QTableWidgetItem *label = new QTableWidgetItem();

    name->setText(ui->tasknamelineEdit->text());
    desc->setText(ui->taskDesclineEdit->text());
    deadline->setText(ui->taskDeadlinelineEdit->text());
    project->setText(ui->taskprojectlineEdit->text());
    label->setText(ui->tasklabellineEdit->text());


    int insertRow = ui->tableWidget_3->rowCount();
    ui->tableWidget_3->insertRow(insertRow);

    ui->tableWidget_3->setItem(insertRow, 1, name);
    ui->tableWidget_3->setItem(name->row(), 2, desc);
    ui->tableWidget_3->setItem(desc->row(), 3, deadline);
    ui->tableWidget_3->setItem(deadline->row(), 4, project);
    ui->tableWidget_3->setItem(project->row(), 5, label);

}

void TodoWindow::on_taskUpdatepushButton_clicked()
{

    QString name = ui->tasknamelineEdit->text();
    QString desc = ui->taskDesclineEdit->text();
    QString deadline = ui->taskDeadlinelineEdit->text();
    QString project = ui->taskprojectlineEdit->text();
    QString label = ui->tasklabellineEdit->text();

    int currentRow = ui->tableWidget_3->currentRow();

    ui->tableWidget_3->item(currentRow, 1)->setText(name);
    ui->tableWidget_3->item(currentRow, 2)->setText(desc);
    ui->tableWidget_3->item(currentRow, 3)->setText(deadline);
    ui->tableWidget_3->item(currentRow, 4)->setText(project);
    ui->tableWidget_3->item(currentRow, 5)->setText(label);

}

void TodoWindow::on_taskDeletepushButton_clicked()
{
    ui->tableWidget_3->removeRow(ui->tableWidget_3->currentRow());

}

void TodoWindow::on_tableWidget_2_clicked(const QModelIndex &index)
{
    int row = index.row();

    ui->labelnamelineEdit->setText(index.sibling(row, 1).data().toString());
}

void TodoWindow::on_tableWidget_3_clicked(const QModelIndex &index)
{
    int row = index.row();

    ui->tasknamelineEdit->setText(index.sibling(row, 1).data().toString());
    ui->taskDesclineEdit->setText(index.sibling(row, 2).data().toString());
    ui->taskDeadlinelineEdit->setText(index.sibling(row, 2).data().toString());
    ui->taskprojectlineEdit->setText(index.sibling(row, 2).data().toString());
    ui->tasklabellineEdit->setText(index.sibling(row, 2).data().toString());
}

void TodoWindow::on_loadDatapushButton_1_clicked()
{

}

void TodoWindow::on_loadDatapushButton_2_clicked()
{

}

void TodoWindow::on_loadDatapushButton_3_clicked()
{

}
