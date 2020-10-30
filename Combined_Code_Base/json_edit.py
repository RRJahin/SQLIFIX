'''
Messy reformation
'''
import json
import re

mydict = {}
mylist = []
mystr = ""
mybool = False

def messyReform(data):
    tlist = []
    if type(data) == type(mylist):
        for element in data:
            newdict = {}
            newdict['label'] = 'dummy'
            newdict['type'] = 'dummy'
            newdict['children'] = messyReform(element)
            tlist.append(newdict)
    else:
        for x in data.keys():
            if type(data[x]) != type(mylist) and type(data[x]) != type(mydict):
                newdict = {}
                newdict['label'] = data[x]
                newdict['type'] = x
                newdict['children'] = []
                tlist.append(newdict)
            else:
                newdict = {}
                newdict['label'] = x
                newdict['type'] = x
                newdict['children'] = messyReform(data[x])
                tlist.append(newdict)
    return tlist

'''
Main part
Messy reformation
'''

import os
import shutil

for base_path in ['Before\\Temp\\','After\\Temp\\'] :
    #directories = [files for root, dirs, files in os.walk(base_path)]
    directories = [x[1]
                for x in os.walk(base_path)]

    for x in directories[0]:
        print(x)
        filelist = [files for root, dirs, files in os.walk(base_path+x)]
        for y in filelist[0]:
            if 'Parsed' in y and '_Parsed' not in y:
                if(os.stat(base_path+x+"\\"+y).st_size == 0):
                    print(x)
                    shutil.rmtree(base_path+x)
                    break
                with open(base_path+x+"\\"+y) as f:
                    data = json.load(f)
                newdict = {}
                newdict['label'] = "root"
                newdict['type'] = "root"
                newdict['children'] = messyReform(data["sqlscript"]["statement"])
                with open(base_path+x+"\\_"+y, 'w') as f:
                    json.dump(newdict, f)
                


'''
Travarce the JSON and Return path to the SQL Query String
children - a list
repeat - is multiple Query in one file then 
        repeat = 0 will find first ocurance, 
        repeat = 1 will find second ocurance
'''

mystr = ""

def find_string(children):
    path = []           # contains path to the query string
    # same shape as "path", continuous 1 if connected to ocurance of query, 0 otherwise
    marker = []

    if len(children) == 0:
        return False, path, marker

    for i in range(len(children)):
        # print(children[i])
        if 'label' not in children[i].keys():
            continue
        if type(children[i]['label']) == type(mystr) and re.search(r'DELETE.*|SELECT.*|INSERT.*|UPDATE.*', children[i]['label'], re.IGNORECASE) != None and children[i]['type'] == 'Literal':
            path.append(i)
            marker.append(1)
            return True, path, marker
        found, nextpath, nextmarker = find_string(children[i]['children'])
        if found == True:
            path.append(i)
            if children[i]['label'] == "PLUS" and nextmarker[0] == 1:
                marker.append(1)
            else:
                marker.append(0)
            path = path + nextpath
            marker = marker + nextmarker
            return True, path, marker

    return False, path, marker


'''
Travarce the children and replace "sqldata" in place using marker
'''


def travarce_replace(children, sqldata, path, marker, pos):
    if pos >= len(marker):
        return children
    if marker[pos] == 0:
        children[path[pos]]['children'] = travarce_replace(
            children[path[pos]]['children'], sqldata, path, marker, pos+1)
    else:
        children[path[pos]] = sqldata

    return children
'''
Main part of Replacing SQL parsed datat in Edit Tree
Change 'Before' 'After' to parse them
'''

import os
import json
import re

base_path = '.'
for ext_path in ['\\Before\\Temp\\','\\After\\Temp\\']:
    #directories = [files for root, dirs, files in os.walk(base_path)]
    now = ''
    if ext_path == '\\Before\\Temp\\':
        now = 'before_tree'
    else:
        now = 'after_tree'
    directories = [x[1]
                for x in os.walk(base_path+ext_path)]

    #print(directories[0])

    for x in directories[0]:
        #fileList = []
        n = int(x.split("_")[1])
        if os.path.isfile(base_path+"\\Edit Trees\\change_pair"+ str(n) +".json"):
            with open(base_path+"\\Edit Trees\\change_pair"+ str(n) +".json") as f:
                data = json.load(f)
            children = data[now]['children']
            filelist = [files for root, dirs, files in os.walk(base_path+ext_path+x)]
            for y in filelist[0]:

                if '_Parsed' in y and os.stat(base_path+ext_path+x+"\\"+y).st_size > 0:
                    #fileList.append(y)
                    (x, y)
                    with open(base_path+ext_path+x+"\\"+y) as r:
                        sqldata = json.load(r)

                    _, path, marker = find_string(children)
                    children = travarce_replace(children, sqldata, path, marker, 0)

                    with open(base_path+"\\Edit Trees\\change_pair"+ str(n) +".json", 'w') as outfile:
                        json.dump(data, outfile)
                print(n, x, filelist)
    
  