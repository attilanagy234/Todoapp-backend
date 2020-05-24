#include "mainwindow.h"

#include <QApplication>
#include <QLabel>

int main(int argc, char *argv[])
{
    QApplication app(argc, argv);
    MainWindow w;
    TodoWindow s;
    w.setWindowTitle("Todoz");
    w.show();
    return app.exec();
}
