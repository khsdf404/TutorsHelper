using System.Diagnostics;
using System.Text;
using System.Text.RegularExpressions;
using Microsoft.Win32;

namespace Program
{

    class Program
    {

        static void Main(string[] args)
        {
            Console.WriteLine("		Wait...");
            openHTML();
        }


        static int getAmount(string str)
        {
            int max = 0;
            while (++max < 1000)
                if (str.IndexOf($@"id=""LC{max}""") == -1)
                    return (max - 1);
            return 2;
        }

        static string[] getGroup()
        {
            string groupTxt = "";
            try
            {
                Uri uri = new Uri("https://github.com/khsdf404/TutorsHelper/blob/main/Executable/GroupMembers.txt");

                System.Net.WebClient client = new System.Net.WebClient();
                client.Encoding = Encoding.UTF8;
                string html = client.DownloadString(uri);
                string areaForSearching = Regex.Split(html, @"id=""spoof-warning""")[1];
                areaForSearching = Regex.Split(html, ("</table>"))[0];
                string areaSaver = areaForSearching;
                for (int i = 0; i < getAmount(areaForSearching); i++)
                {
                    areaForSearching = Regex.Split(areaForSearching, $@"<td id=""LC{i + 1}"" class=""blob-code blob-code-inner js-file-line"">")[1];
                    groupTxt += Regex.Split(areaForSearching, "</td>")[0];
                    groupTxt += "\n";
                    areaForSearching = areaSaver;
                }
                groupTxt = groupTxt.Substring(0, groupTxt.Length - 1);

                return Regex.Split(groupTxt, @"\n");
            }
            catch
            {
                return new string[0];
            }
        }
        static string groupToJsArray()
        {
            string output = "[ ";
            string[] groupList = getGroup();
            for (int i = 0; i < groupList.Length - 1; i++)
                output += @" """ + groupList[i] + @""", ";
            output += $@" ""{groupList[groupList.Length - 1]}"" ]  ";
            return output;
        }

        static string[] getTasks()
        {
            string tasksTxt = "";
            try
            {
                Uri uri = new Uri("https://github.com/khsdf404/TutorsHelper/blob/main/Executable/TasksConfig.txt");

                System.Net.WebClient client = new System.Net.WebClient();
                client.Encoding = Encoding.UTF8;
                string html = client.DownloadString(uri);
                string areaForSearching = Regex.Split(html, ("id=\"spoof-warning\""))[1];
                areaForSearching = Regex.Split(html, ("</table>"))[0];
                string areaSaver = areaForSearching;
                /*string areaForSearching = html
                     .Split("id=\"spoof-warning\"")[1]
                     .Split("</table>")[0];*/
                for (int i = 0; i < getAmount(areaForSearching); i++)
                {
                    areaForSearching = Regex.Split(areaForSearching, $@"<td id=""LC{i + 1}"" class=""blob-code blob-code-inner js-file-line"">")[1];
                    tasksTxt += Regex.Split(areaForSearching, "</td>")[0];
                    tasksTxt += "\n";
                    areaForSearching = areaSaver;
                }
                tasksTxt = tasksTxt.Substring(0, tasksTxt.Length - 1);
                return Regex.Split(tasksTxt, @"\n");
            }
            catch
            {
                return new string[0];
            }
        }
        static string taskToJsArray()
        {
            string output = "[ ";
            string[] taskList = getTasks();
            for (int i = 0; i < taskList.Length - 1; i++)
                output += @" """ + taskList[i] + @""", ";
            output += $@" ""{taskList[taskList.Length - 1]}"" ]  ";
            return output;
        }


        static string getHTML()
        {
            string htmlCode = $@"
        <!doctype html>
<html>
<head>
	<meta http-equiv=""Content-type"" content=""text/html; charset=utf-8"">
	<meta http-equiv=""X-UA-Compatible"" content=""IE=Edge"">
	<title>IKBO-02-21</title>
	<script src=""https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js""></script>
 
</head>
<body>
	<style media=""screen"">
			html, body {{margin: 0;
    padding: 0;
    height: 100%;
    width: 100%;
    overflow: hidden;
}}
body {{position: relative;
  display: flex;
  flex-direction: row;
  height: 86%;
  width: 90%;
  padding: 4% 5% ;
  background: rgba(45, 45, 45, 0.9);
}}

.wrapp {{display: flex;
  flex-direction: row;
  flex: 1;
}}
.groupWrapp {{display: flex;
  height: 100%;
  flex-direction: column;
  flex: 20;
}}
.groupWrapp div {{border: .5px solid rgba(0,0,0,0.3);
  flex: 1;
  border-radius: 3px;
  background: #bbb;
  overflow: hidden;
  display: flex;
  align-items: center;
  padding-left: 5%;
}}
.gridWrapp {{position: relative;
  display: flex;
  flex-direction: column;
  flex: 80;
}}
.taskWrapp {{display: flex;
    flex-direction: column;
    width: 100%;
    height: 100%;
}}
.gridWrapp ul {{flex - direction: row;
  display: flex;
  flex: 1;
  line-height: 0;
  font-size: 0;
  list-style: none;
  padding: 0;
  margin: 0;
}}
.gridWrapp ul li {{flex: 1;
  border: .5px solid rgba(0,0,0,0.1);
  border-radius: 1.5px;
}}
.liTrue {{background: rgba(108, 180, 255, 1); }}
.liFalse {{background: rgba(255, 67, 89, 0.8); }}

	</style>

	<div class=""wrapp"">
		<div class=""groupWrapp"">
		</div>
		<div class=""gridWrapp"">
			<div class=""taskWrapp"">
			</div>
		</div>
	</div>


	<script type=""text/javascript"">
			$('document').ready(function () {{
					let groupList = {groupToJsArray()};
					let taskList = {taskToJsArray()};
					let taskAmount = taskList[0].length;
                    let studentAmount = groupList.length;
					function setTasks() {{
            let width = $(`.gridWrapp`).outerWidth();
            $(`.taskWrapp`).append(`<ul></ul>`);
            for (let i = 0; i < taskAmount; i++) {{
               $(`.taskWrapp ul`).append(`<li>${{i+1}}</li>`);
            }}
            $(`.taskWrapp ul li`).css({{
              'display': 'flex',
              'justify-content': 'center',
              'align-items': 'center',
              'font-size': '16px',
              'background': '#ccc'}});
        }}
        function setGrid() {{
            for (let j = 0; j < studentAmount; j++) {{
              $(`.taskWrapp`).append(`<ul></ul>`);
              for (let i = 0; i < taskAmount; i++) {{
                let cl =  taskList[j][i]  == `+` ? 'liTrue' : 'liFalse';
                 $(`.taskWrapp ul`).eq(j+1).append(`<li class=${{cl}}></li>`);
              }}
            }}
        }}
        function setStudents() {{
          let width = $(`.groupWrapp`).outerWidth();
          $(`.groupWrapp`).append(`<div>123</div>`);
          for (let i = 0; i < studentAmount; i++) {{
              $(`.groupWrapp`).append(`<div>  ${{i + 1}}. ${{groupList[i]}}</div>`);
          }}
          $(`.groupWrapp div`).eq(0).css({{
            'color': 'rgba(45, 45, 45, 0)',
            'background': 'transparent',
            'border-top': '1px solid',
            'border-left': '1px solid'
          }});
          $(`.groupWrapp div`).css({{
            'max-height': $(`.taskWrapp ul li`).eq(0).outerHeight()
          }});
        }}
        function setFontSize() {{
            let max = 0;
            for (let i = 0; i < groupList.length; i++)
              if (groupList[i].length > max) max = groupList[i].length;
              let fs = 2*$(`.groupWrapp div`).outerWidth()/(max + 6);
              fs += $(`.groupWrapp div`).outerHeight()/(1.6);
              let fontSize = fs/2.5 + 'px';
            $(`.groupWrapp div`).css({{
              'font-size': fontSize
            }});
        }}

        setTasks();
        setGrid();
        setStudents();
        setFontSize();
        $(window).resize(function () {{
              setFontSize();
              $(`.groupWrapp div`).css({{
                'max-height': $(`.taskWrapp ul li`).eq(0).outerHeight()
              }});
        }})

    }});
	</script>

</body>
</html>

    ";

            return htmlCode;
        }
        static void openHTML()
        {
            string path = Environment.CurrentDirectory + "\\text.html";
            File.WriteAllText(path, getHTML());
            Process.Start(getBrowserPath(), "\"" + path + "\"");
            System.Threading.Thread.Sleep(1000);
            File.Delete(path);
        }


        static string getBrowserPath()
        {
            const string userChoice = @"Software\Microsoft\Windows\Shell\Associations\UrlAssociations\http\UserChoice";
            string progId;
            using (RegistryKey userChoiceKey = Registry.CurrentUser.OpenSubKey(userChoice))
            {
                object progIdValue = userChoiceKey.GetValue("Progid");
                progId = progIdValue.ToString();
            }

            const string exeSuffix = ".exe";
            string path = progId + @"\shell\open\command";
            FileInfo browserPath;
            using (RegistryKey pathKey = Registry.ClassesRoot.OpenSubKey(path))
            {
                if (pathKey == null) return "";
                try
                {
                    path = pathKey.GetValue(null).ToString().ToLower().Replace("\"", "");
                    if (!path.EndsWith(exeSuffix))
                    {
                        path = path.Substring(0, path.LastIndexOf(exeSuffix, StringComparison.Ordinal) + exeSuffix.Length);
                        browserPath = new FileInfo(path);
                        return browserPath.FullName;
                    }
                }
                catch
                {
                    return "";
                }
            }
            return "";
        }

    }


}





