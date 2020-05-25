#include "mainwindow.h"

#include <QApplication>
#include <QLabel>

int main(int argc, char *argv[])
{
    QApplication app(argc, argv);
    MainWindow w;

    w.get("https://postman-echo.com/get?foo1=bar1&foo2=bar2");

   /*
    QByteArray data;
    data.append("param1=hello");
    data.append("&");
    data.append("param2=foo");

    w.post("https://postman-echo.com/post", data);
*/

    w.setWindowTitle("Todoz");
    w.show();
    return app.exec();
}
