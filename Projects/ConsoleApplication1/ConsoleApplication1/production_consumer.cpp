#include <stdlib.h>
#include <iostream>
#include <thread>
#include <string>
#include <ctime>
#include <windows.h>
#include <mutex>

using namespace std;
#define  GOOGS_MAX 10

mutex mute1;

class Good
{
public:
    Good()
    {
    }
    Good(string name)
    {
        this->name = name;
    }
    ~Good()
    {
    }


    string toString()
    {
        return "name:" + this->name;
    }


private:
    string name;
};

class GoodsManager
{
public:
    GoodsManager::GoodsManager()
    {
    }
    GoodsManager::~GoodsManager()
    {
    }
    //生产
    void productGood()
    {
        while(true)
        {
            mute1.lock();

            if(!needPro)
            {
                mute1.unlock();
                break;
            }

            if(index >= GOOGS_MAX)
            {
                cout << "good is FULL,wait consumer..." << endl;
                mute1.unlock();
                Sleep(1000);

            }
            else
            {
                Good g = Good(to_string(index));
                cout << "product one good ." << endl;
                gs[index++] = g;
                mute1.unlock();
                Sleep(200);
            }
        }
    }

    //消费
    void consumeGood()
    {
        int consum_num = 0;

        while(true)
        {
            mute1.lock();

            if(consum_num > 10)
            {
                needPro = false;
                mute1.unlock();
                break;
            }

            if(index <= 0)
            {
                cout << "\t\t\tgoods is Empty,wait product..." << endl;
                mute1.unlock();
                Sleep(200);
            }
            else
            {
                Good g = gs[--index];
                cout << "\t\t\t\t\t\tconsume one good ." << endl;
                consum_num++;

                mute1.unlock();
                Sleep(100);
                //删除g对象

            }
        }
    }

    //初始化
    void init()
    {
        index = 0;
        needPro = true;

        thread productor(&GoodsManager::productGood, this);
        thread consumer(&GoodsManager::consumeGood, this);
        productor.detach();
        consumer.detach();

        cout << "in main thread" << endl;
        return;
    }
private:
    Good gs[GOOGS_MAX];
    int index;
    bool needPro;
};

void main()
{
// 	GoodsManager gM = GoodsManager();
// 	gM.init();

    long a = 1, b = 2;
    cout << a % b << endl;

    system("pause");
    return;
}