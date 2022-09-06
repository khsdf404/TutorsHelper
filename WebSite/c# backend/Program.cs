using System.Diagnostics; 
using Microsoft.Win32;


string[] getGroup() {
    string groupTxt = "";
    try {
        Uri uri = new Uri("https://github.com/khsdf404/TutorsHelper/blob/main/Executable/GroupMembers.txt");

        string html = new System.Net.WebClient().DownloadString(uri);
        for (int i = 0; i < 29; i++)
        {
            groupTxt += html
                    .Split("<td id=\"LC" + (i + 1) + "\" class=\"blob-code blob-code-inner js-file-line\">")[1]
                    .Split("</td>")[0];
            groupTxt += "\n";
        }
        groupTxt = groupTxt.Substring(0, groupTxt.Length - 1); 
        return groupTxt.Split("\n");
    }
    catch { 
        return new string[0];
    } 
}
string groupToJsArray() { 
    string output = "[ ";
	string[] groupList = getGroup();
	for (int i = 0; i < groupList.Length - 1; i++)
		output += @" """ + groupList[i] + @""", "; 
	output += $@" ""{groupList[groupList.Length - 1]}"" ]  ";
    return output;
}

string[] getTasks() {
    string tasksTxt = "";
    try {
        Uri uri = new Uri("https://github.com/khsdf404/TutorsHelper/blob/main/Executable/TasksConfig.txt");

        string html = new System.Net.WebClient().DownloadString(uri);
        for (int i = 0; i < 29; i++) {
            tasksTxt += html
                    .Split("<td id=\"LC" + (i + 1) + "\" class=\"blob-code blob-code-inner js-file-line\">")[1]
                    .Split("</td>")[0];
            tasksTxt += "\n";
        }
        tasksTxt = tasksTxt.Substring(0, tasksTxt.Length - 1); 
        return tasksTxt.Split("\n");
    }
    catch
    {
        return new string[0];
    }
}
string taskToJsArray() { 
    string output = "[ ";
    string[] taskList = getTasks();
    for (int i = 0; i < taskList.Length - 1; i++)
        output += @" """ + taskList[i] + @""", ";
    output += $@" ""{taskList[taskList.Length - 1]}"" ]  ";
    return output;
}


string getHTML() {
    string htmlCode = @$"
        <!doctype html>
<html>
<head>
	<meta http-equiv=""Content-type"" content=""text/html; charset=utf-8"">
	<meta http-equiv=""X-UA-Compatible"" content=""IE=Edge"">
	<title>IKBO-02-21</title>
	<script src=""https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js""></script>
	<!-- <link rel=""stylesheet"" href=""styles.css"">  -->

	<!-- <script type=""text/javascript"" src=""scripts.js""></script> -->
</head>
<body>
	<style media=""screen"">
			html, body {{
					margin: 0;
					padding: 0;
					height: 100%;
					width: 100%;
					overflow: hidden;
			}}
			body {{
				position: relative;
				display: flex;
				flex-direction: row;
				height: 70%;
				width: 90%;
				padding: 7% 5% ;
				background: rgba(45, 45, 45, 0.9);
			}}

			.wrapp {{
				display: flex;
				flex-direction: row;
				flex: 1;
			}}
			.groupWrapp {{
				display: flex;
				height: 100%;
				flex-direction: column;
				flex: 20;
			}}
			.groupWrapp div {{
				border: .5px solid rgba(0,0,0,0.3);
				flex: 1;
				border-radius: 3px;
				background: #bbb;
				font-size: 14px;
				overflow: hidden;
			}}
			.gridWrapp {{
				position: relative;
				display: flex;
				flex-direction: column;
				flex: 80;
			}}
			.taskWrapp {{
					display: flex;
					flex-direction: column;
					width: 100%;
					height: 100%;
			}}
			.gridWrapp ul {{
				flex-direction: row;
				display: flex;
				flex: 1;
				line-height: 0;
				font-size: 0;
				list-style: none;
				padding: 0;
				margin: 0;
			}}
			.gridWrapp ul li {{
				flex: 1; 
				border: .5px solid rgba(0,0,0,0.1);
				border-radius: 1.5px;
			}}
			.liTrue {{ background: rgba(108, 180, 255, 1); }}
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
					function setTasks() {{
							let width = $(`.gridWrapp`).outerWidth();
							$(`.taskWrapp`).append(`<ul></ul>`);
							for (let i = 0; i < 32; i++) {{
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
							for (let j = 0; j < 29; j++) {{
								$(`.taskWrapp`).append(`<ul></ul>`);
								for (let i = 0; i < 32; i++) {{
									let cl =  taskList[j][i]  == `+` ? 'liTrue' : 'liFalse';
									 $(`.taskWrapp ul`).eq(j+1).append(`<li class=${{cl}}></li>`);
								}}
							}}
					}}
					function setStudents() {{
						let width = $(`.groupWrapp`).outerWidth();
						$(`.groupWrapp`).append(`<div>123</div>`);
						for (let i = 0; i < 29; i++) {{
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

					setTasks();
					setGrid();
					setStudents();
			}});
	</script>

</body>
</html>

    ";

	return htmlCode;
}
void openHTML() {
	string path = Environment.CurrentDirectory + "\\text.html";
	File.WriteAllText(path, getHTML()); 
    Process.Start(getBrowserPath(), "\"" + path + "\"");
	Thread.Sleep(1000);
	File.Delete(path);
}


string getBrowserPath() {
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
        try {
            path = pathKey.GetValue(null).ToString().ToLower().Replace("\"", "");
            if (!path.EndsWith(exeSuffix)) {
                path = path.Substring(0, path.LastIndexOf(exeSuffix, StringComparison.Ordinal) + exeSuffix.Length);
                browserPath = new FileInfo(path);
                return browserPath.FullName;
            }
        }
        catch {
			return "";
        }
    }
	return "";
}

Console.WriteLine("		Wait...");
openHTML();