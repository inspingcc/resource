# -*- coding: utf-8 -*-
import thread,time,os
import win32api,win32con

def in_home():
    p=os.popen("ping -n 1 -w 1 127.0.0.1")
    if p.read().find("请求超时") == -1:
        return 1
    else:
        return 0 

def do_thing(ensure,i):
    content = "Open the door ,now?"
    if i >= 3:
        content = "Open the fuck door,now!!!!!!!!"
    if ensure == 2:
        content = "are you sure that you go ?"
    return win32api.MessageBox(0, content, "xiao Gaoyang ",win32con.MB_YESNO)

while(1!=0):
    if in_home() == 1:
        i=1
        ensure = 1
        while(i<100):
            result = do_thing(ensure,i)
            if ensure < 2:
                ensure+=1
            else:
                if result == 6:#YES
                    time.sleep(5);
                    os.system("taskkill /f /im pythonw.exe")
                    break;
            i=i+1
    time.sleep(2)


