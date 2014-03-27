
name := "mongo-hadoop"

organization := "io.prediction"


hadoopRelease in ThisBuild := "default"

publishMavenStyle in ThisBuild := true

publishTo in ThisBuild <<= version { (v: String) =>
  val nexus = "https://oss.sonatype.org/"
  if (v.trim.endsWith("SNAPSHOT"))
    Some("snapshots" at nexus + "content/repositories/snapshots")
  else
    Some("sonatype-releases"  at nexus + "service/local/staging/deploy/maven2")
}

pomIncludeRepository in ThisBuild := { _ => false }

pomExtra in ThisBuild := (
  <url>http://github.com/mongodb/casbah</url>
  <licenses>
      <license>
          <name>Apache 2</name>
          <url>http://www.apache.org/licenses/LICENSE-2.0.html</url>
          <distribution>repo</distribution>
      </license>
  </licenses>
  <scm>
      <url>git@github.com:mongodb/casbah.git</url>
      <connection>scm:git:git@github.com:mongodb/casbah.git</connection>
  </scm>
  <developers>
      <developer>
          <id>brendan</id>
          <name>Brendan W. McAdams</name>
          <url>http://blog.evilmonkeylabs.net</url>
      </developer>
  </developers>)

useGpg in ThisBuild := true

credentials in ThisBuild += Credentials(Path.userHome / ".sbt" / "sonatype.credentials")
