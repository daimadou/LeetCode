class Solution {
public:
    string simplifyPath(string path) {
        // Start typing your C/C++ solution below
        // DO NOT write int main() function
        int i = 0;
        int n = path.size();
        int start = 0;
        list<string>directorylist;
        if(path[n-1]!='/')
        {
            path += '/';
            n++;
        }
        while(i < n)
        {
            string directory;
            if(path[i] == '/')
            {
                directory = path.substr(start, i - start );
                if(directory=="..")
                {
                    if(!directorylist.empty())
                        directorylist.pop_back();
                }
                else if(!directory.empty()&&directory!=".")
                {
                    directorylist.push_back(directory);
                }
                start = i+1;
            }
            i++;
        }
        
        string simplyPath;
        while(!directorylist.empty())
        {
            simplyPath += '/'+directorylist.front();
            directorylist.pop_front();
        }
        
        if(simplyPath.empty())
            return "/";
        else
            return simplyPath;
    }
};

