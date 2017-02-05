#include <thread>
#include <iostream>
#include <windows.h>
#include <mutex>

using namespace std;

mutex mute;

class TicketManager
{
public:
    TicketManager::TicketManager()
    {
    }
    TicketManager::~TicketManager()
    {
    }

    void saleA()
    {
        while(true)
        {
            mute.lock();

            if(ticket_sum > 0)
            {
                //Sleep(100);
                cout << "A sell ticket(no.) :" << ticket_sum-- << endl;
                mute.unlock();
            }
            else
            {
                break;
            }
        }
    }
    void saleB()
    {
        while(true)
        {
            mute.lock();

            if(ticket_sum > 0)
            {
                //Sleep(100);
                cout << "B sell ticket(no.) :" << ticket_sum-- << endl;
                mute.unlock();
            }
            else
            {
                break;
            }
        }
    }

    void init()
    {
        ticket_sum = 100;
        thread tA(&TicketManager::saleA, this);
        thread tB(&TicketManager::saleB, this);
        tA.detach();
        tB.detach();

        cout << "in main thread" << endl;
        return;
    }
private:
    int ticket_sum;
};

//void main()
//{
//    TicketManager ticketManager = TicketManager();
//    ticketManager.init();
//
//
//    system("pause");
//    return;
//}

