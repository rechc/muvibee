del .\MuViBee.properties
del .\MuViBee_de.properties
del .\MuViBee_ru.properties
del .\MuViBee_tr.properties
%JAVA_HOME%\bin\native2ascii -encoding UTF8 .\init_language\MuViBee_init.properties .\MuViBee.properties
%JAVA_HOME%\bin\native2ascii -encoding UTF8 .\init_language\MuViBee_de_init.properties .\MuViBee_de.properties
%JAVA_HOME%\bin\native2ascii -encoding UTF8 .\init_language\MuViBee_ru_init.properties .\MuViBee_ru.properties
%JAVA_HOME%\bin\native2ascii -encoding UTF8 .\init_language\MuViBee_tr_init.properties .\MuViBee_tr.properties
