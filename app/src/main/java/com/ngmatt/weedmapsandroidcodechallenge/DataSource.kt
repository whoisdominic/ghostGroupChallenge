package com.ngmatt.weedmapsandroidcodechallenge

import com.ngmatt.weedmapsandroidcodechallenge.models.YelpBusiness

class DataSource{

    companion object{

        fun createDataSet(): ArrayList<YelpBusiness>{
            val list = ArrayList<YelpBusiness>()
            list.add(
                YelpBusiness(
                    "Uno Dos Tacos",
                    "You made it to the end of the course!\r\n\r\nNext we'll be building the REST API!",
                    "https://s3-media3.fl.yelpcdn.com/bphoto/e7GbDjpwY2-MS4FaR6VaRw/o.jpg",
                    4.0
                )
            )
            list.add(
                YelpBusiness(
                    "Buena Vida Cantina",
                    "The REST API course is complete. You can find the videos here: https://codingwithmitch.com/courses/build-a-rest-api/.",
                    "https://s3-media1.fl.yelpcdn.com/bphoto/M6AaDCe57FN2hyCZ2qS0Bw/o.jpg",
                    5.0
                )
            )

            list.add(
                YelpBusiness(
                    "Garaje",
                    "Justin has been producing online courses for YouTube, Udemy, and his website CodingForEntrepreneurs.com for over 5 years.",
                    "https://s3-media1.fl.yelpcdn.com/bphoto/B5UcvKFCAMNZ5O8e-bx-pg/o.jpg",
                    4.5
                )
            )
            list.add(
                YelpBusiness(
                    "Tacos El Patrón",
                    "Vasiliy has been a freelance android developer for several years. He also has some of the best android development courses I've had the pleasure of taking on Udemy.com.",
                    "https://s3-media2.fl.yelpcdn.com/bphoto/fkgyZbyYP7evChd0trFinA/o.jpg",
                    4.0
                )
            )
            list.add(
                YelpBusiness(
                    "Chisme Cantina",
                    "Freelancing as an Android developer with Donn Felker.\\r\\n\\r\\nDonn is also:\\r\\n\\r\\n1) Founder of caster.io\\r\\n\\r\\n2) Co-host of the fragmented podcast (fragmentedpodcast.com).",
                    "https://s3-media3.fl.yelpcdn.com/bphoto/VLj4WylvSfoUB9ove5QoNA/o.jpg",
                    4.5
                )
            )
            list.add(
                YelpBusiness(
                    "Taco Guapo",
                    "What kind of hobbies do software developers have? It sounds like many software developers don't have a lot of hobbies and choose to focus on work. Is that a good idea?",
                    "https://s3-media2.fl.yelpcdn.com/bphoto/ChN5tj0dvAPlV7Po_gLCIg/o.jpg",
                    4.0
                )
            )
            list.add(
                YelpBusiness(
                    "El Fuego",
                    "In this podcast I interviewed the Fullsnack Developer (AKA Nicholas Olsen).\\r\\n\\r\\nNicholas is many things. What I mean by that is, he's good at many things.\\r\\n\\r\\n1. He’s an entrepreneur\\r\\n\\r\\n2. Web developer\\r\\n\\r\\n3. Artist\\r\\n\\r\\n4. Graphic designer\\r\\n\\r\\n5. Musician (drums)\\r\\n\\r\\n6. Professional BodyBuilder.",
                    "https://s3-media1.fl.yelpcdn.com/bphoto/l8ytcnmQXkDkigsLULF_mw/o.jpg",
                    5.0
                )
            )
            list.add(
                YelpBusiness(
                    "Tacolicious Chico",
                    "Interviewing a web developer, javascript expert, entrepreneur, freelancer, podcaster, and much more.",
                    "https://s3-media3.fl.yelpcdn.com/bphoto/50wgUzBZci1T_GgzrhhbCg/o.jpg",
                    4.0
                )
            )
            list.add(
                YelpBusiness(
                    "Tacorea",
                    "Kaushik Gopal is a Senior Android Engineer working in Silicon Valley.\r\n\r\nHe works as a Senior Staff engineer at Instacart.\r\n\r\nInstacart: https://www.instacart.com/",
                    "https://s3-media1.fl.yelpcdn.com/bphoto/wWmEPL-j9NwP6zPhMF-SHg/o.jpg",
                    4.5
                )
            )
            return list
        }
    }
}