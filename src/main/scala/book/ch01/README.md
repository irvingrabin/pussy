Logic of Type Classes

            Json <- typeClass

            JsonWriter - operations on type class
                JsonWriter[String]
                JsonWriter[Double]
                JsonWriter[Person]

            Bindings:

                Interface Objects:
                    Json defines method toJson for all parameter classes
                        for which we have JsonWriter defined.
                    For all of them we can call Json.toJson(x)

                InterfaceSyntax
                     Syntax object defines promotion to all classes for which
                        we have JsonWriter defined.
                     Then for all values of those classes we can call x.toJson



