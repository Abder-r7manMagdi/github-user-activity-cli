param (
    [Parameter(Mandatory=$true)]
    [string]$username
)

# مسار JDK 24
$javaPath = "C:\Users\mmgdy\.jdks\openjdk-24.0.2\bin\java.exe"

# مسار ملفات الكلاس
$classPath = "D:\Java\GitHub User Activity\out\production\GitHub User Activity"

# تشغيل البرنامج
& $javaPath -cp $classPath Main $username
