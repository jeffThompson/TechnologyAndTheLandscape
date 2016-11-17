![An image of one of the many, many possible worlds in the game "No Man's Sky"](https://raw.githubusercontent.com/jeffThompson/TechnologyAndTheLandscape/master/Images/Week12/NoMansSky.jpg)

WEEK 12: ALGORITHMIC LANDSCAPES
====

> "The development of an organism... may be considered as the execution of a 'developmental program' present in the fertilized egg... A central task of developmental biology is to discover the underlying algorithm from the course of development." – Aristid Lindenmayer and Grzegorz Rozenberg (quoted in *Computational Beauty of Nature*)

Last week, we looked at landscapes that were imagined, perhaps drawn or painted (digitally or using analog methods), or existing only as words. But those places are only onscreen in small fragments and in our imaginations. This week, we'll look at wholly generated worlds, ones that simultaneously exist fully-formed (often so intricate as to have working systems like weather or erosion) and yet are only numbers. Many, like the games *No Man's Sky* and *Dwarf Fortress\**, are generated with immense levels of detail, more than we will even be able to actually see. Others, such as landscape-generating Twitter bots, are more humble, made with a some code and a few scraps of Unicode.

[Procedural content generation](http://pcgbook.com)\*\*, a process for making game and film assets through code rather than by hand, allows for customizable, unique, and detailed experiences that wouldn't be possible by more traditional methods. Landscapes generated this way allow for the modeling of processes (such as glaciation), the inclusion of pure mathematics (such as fractal geometry), and the correlation of data to space (like [heightmaps](https://en.wikipedia.org/wiki/Heightmap)).

\* You can read lots more on the making of *No Man's Sky* in [this New Yorker piece](http://www.newyorker.com/magazine/2015/05/18/world-without-end-raffi-khatchadourian).  

\*\* If you get really into this, there is an annual [Procedural Generation Jam](https://itch.io/jam/procjam), whose site include [5 hours of amazing talks](https://www.youtube.com/watch?v=3wcpLwvBTYo) on the subject. You can also read **lots** more [here](http://vterrain.org/Elevation/Artificial) and [here](http://www.world-creator.com).

*Above: An image of one of the many, many possible worlds in the game "No Man's Sky"; below, a screenshot of terrain generation software.*

![Screenshot of terrain generation software](https://raw.githubusercontent.com/jeffThompson/TechnologyAndTheLandscape/master/Images/Week12/TerrainGeneration2.jpg)

###IN CLASS  
Today in class, we're going to think about the landscape not from the perspective of humans (as we have all semester), but instead from the perspective of a machine. The U.S. National Oceanic and Atmospheric Administration (NOAA), which has some of the best and easiest to access data sets around, has a website dedicated to [data buoys](http://www.ndbc.noaa.gov), autonomous buoys floating across the world's oceans, collecting water temperature, salinity, wind speed, and other data.

Inspired by the Twitter bot [@_LostBuoy_](https://twitter.com/_LostBuoy_), which combines lines from Moby Dick and realtime information from the NOAA buoys, your assignment is to pick a buoy from the site and make something from its perspective. If you want to try your hand at creating a bot using the data, you can use [Cheap Bots Done Quick](http://cheapbotsdonequick.com) (though the learning curve is a bit high). But don't feel like you need to make anything high tech – you could also think about making a set of drawings, poems, diary entries, a song... anything. We'll spend the day working on this project, so pick something substantial and that is more than just a cursory exploration – really think about how you can understand the landscape from this machine's perspective, how it differs from or is similar to ours, and about how you can have an empathetic relationship with technology.

You can get data for the last year using the following URL format:

    http://www.ndbc.noaa.gov/data/stdmet/<month>/<buoy #>.txt

Which, for buoy 41041 in October, becomes this URL:

    http://www.ndbc.noaa.gov/data/stdmet/Oct/41041.txt

And returns data like this:

	#YY  MM DD hh mm WDIR WSPD GST  WVHT   DPD   APD MWD   PRES  ATMP  WTMP  DEWP  VIS  TIDE
	#yr  mo dy hr mn degT m/s  m/s     m   sec   sec deg    hPa  degC  degC  degC  nmi    ft
	2016 09 30 23 50  84  6.9  8.1  1.81  7.69  5.62  73 1012.6  27.1  28.1  22.2 99.0 99.00
	2016 10 01 00 50  86  5.4  6.2  1.80  7.14  5.51  97 1013.9  27.2  28.1  22.1 99.0 99.00
	2016 10 01 01 50 109  3.9  4.8  1.77  8.33  5.91  79 1014.5  27.0  28.0  22.5 99.0 99.00
	2016 10 01 02 50 189  0.2  1.1  1.79  7.14  5.90  85 1014.3  26.5  28.0  22.1 99.0 99.00
	2016 10 01 03 50  60  3.1  4.1  1.83  7.14  6.24  65 1012.7  26.3  28.0  22.1 99.0 99.00
	2016 10 01 04 50  52  6.1  7.5  1.63  8.33  5.84  60 1011.7  26.3  28.0  22.5 99.0 99.00
	2016 10 01 05 50  68  6.4  7.5  1.64  7.69  5.84  57 1011.0  26.6  28.0  22.2 99.0 99.00
	2016 10 01 06 50  78  6.1  7.3  1.65  8.33  5.97  53 1010.6  26.7  28.0  22.3 99.0 99.00
	2016 10 01 07 50  85  6.6  7.8  1.47  7.69  5.66  70 1011.0  26.8  28.0  22.5 99.0 99.00
	2016 10 01 08 50  90  7.0  8.3  1.52  7.14  5.52  68 1011.1  27.1  28.0  22.3 99.0 99.00
	2016 10 01 09 50  88  6.7  7.8  1.64  8.33  5.76  66 1011.8  27.2  28.0  22.4 99.0 99.00
	2016 10 01 10 50  90  7.0  8.3  1.53  7.69  5.66  68 1012.2  27.7  28.0  21.8 99.0 99.00

Descriptions of what these columns mean is [available here](http://www.ndbc.noaa.gov/measdes.shtml). Not all buoys are active, and not all will have data like above, but this is a good place to start.

###PROJECTS/THINGS SHOWN  
* The epic terrain and history-generating game [Dwarf Fortress](http://www.bay12games.com/dwarves)  
* [No Man's Sky](http://www.no-mans-sky.com), the much-heralded game featuring 18-quintillion planets, each with their own flora and fauna  
* Hacking *Super Mario 64* by literally [walking through the source code inside the game](https://www.youtube.com/watch?v=kpk2tdsPh0A)  
* The classic [Sim City](https://en.wikipedia.org/wiki/SimCity_(1989_video_game)) game franchise, started in 1989  
* (Architect [Michael Sorkin has said](https://books.google.com/books?id=QSSNBwAAQBAJ&lpg=PA89&ots=o5UfhQCpn_&dq=michael%20sorkin%20simcity&pg=PA89#v=onepage&q=michael%20sorkin%20simcity&f=false), inspired by *Sim City*, that "if you know everything about a given metropolis, from its plumbing standards to its parking requirements, its sewer capacity to the borders of its school districts, then you coud more or less accurately imagine the future form of that city from the ground up".)  
* Another classic, [*Roller Coaster Tycoon*](https://en.wikipedia.org/wiki/RollerCoaster_Tycoon)  
* The insanely detailed software package [SpeedTree](http://www.speedtree.com), used for making hyper-realistic trees for games and animations (they offer a free trial, if you want to try it out) – a [few](https://www.youtube.com/watch?v=rucfLNcDnPM) [examples](https://www.youtube.com/watch?v=r18c7QlWLBQ)  
* The very, very deep world of fractal exploration, including [this list of fractals by their Hausdorff dimension](https://en.wikipedia.org/wiki/List_of_fractals_by_Hausdorff_dimension) and [The Unraveling of the Real 3D Mandelbulb](http://www.skytopia.com/project/fractal/mandelbulb.html)  
* Similar to fractals, cellular automata like [Langton's ant](https://en.wikipedia.org/wiki/Langton%27s_ant)  
* Artist Kim Laughton's [screenshots of *Grand Theft Auto*](http://www.monaddigital.net/espaceexpo/7thWebExpo/7we_kim_laughton.html), modified to include no 3D textures  
* Work by the artist duo Semiconductor, including [*Catching the Light*](http://semiconductorfilms.com/art/catchingthelight) and [*Earthworks*](http://semiconductorfilms.com/art/earthworks)  
* Artist Angela Washko, whose work includes [interventions in the game *World of Warcraft*](http://angelawashko.com/artwork/3813025-misplay-Episode-1-A-Scantily-Clad-Parade-of-Orcs-and-Trolls-in-World-of-Warcraft.html)  
* * Artist [Katie Rose Pipkin's](http://katierosepipkin.com) [*Mirror Lake*](https://katierose.itch.io/mirrorlake)  
* Artist Jakob Kudsk Steensen's hyper-realistic VR project *Primal Tourism* ([walkthrough](http://www.jakobsteensen.com/primal-tourism) and [tour](http://www.jakobsteensen.com/work/#/primal-tourism-tour))  
* Flickr's "magic view," which uses machine learning to tag and sort images, including moments of mistaken tagging where it imagines landscapes where they don't exist  

**Bots:**  

* [@unchartedatlas](https://twitter.com/unchartedatlas) ([waaayyy more detail](http://mewo2.com/notes/terrain) on this amazing bot)  
* Also by Katie Rose Pipkin, [@tiny_star_field](https://twitter.com/tiny_star_field), [@viewgenerator](https://twitter.com/viewgenerator), [@unicode_birds](https://twitter.com/unicode_birds), and [@mothgenerator](https://twitter.com/mothgenerator)  
* [@dungeon_bot](https://twitter.com/dungeon_bot), featuring a procedural dungeon and a poor wanderer stuck inside (made by me 😊)  
* Landscape-generating bots such as [@softlandscapes](https://twitter.com/softlandscapes), [@__birds__](https://twitter.com/__birds__), [@cavebot](https://twitter.com/_cavebot), [@wildflowersbot](https://twitter.com/wildflowersbot), [@lycanthrobot](https://twitter.com/lycanthrobot), [@choochoobot](https://twitter.com/choochoobot), and [@tinyskylines](https://twitter.com/tinyskylines)  
* Lots more emoji-based landscape bots via [this list](https://twitter.com/muffinista/lists/tableau-ji)  
* Description-generating bots, like [@spacetravelbot](https://twitter.com/spacetravelbot), [@str_voyage](https://twitter.com/str_voyage), [@thanetguide](https://twitter.com/thanetguide), [@a_travel_bot](https://twitter.com/a_travel_bot), [@cant_miss_it](https://twitter.com/cant_miss_it), and [@gardensbritish](https://twitter.com/gardensbritish)  

###HOMEWORK: FINAL PROJECT  
Your final project should be a culmination of the class: a project of some kind that explores the intersection of technology and the landscape. This can be an artwork, research project, or other critical and creative work. Think about the different topics we've covered, things we didn't have time to get to in depth, time periods, and ways that the impacts of technology on the landscape reverberate outward. Think too about what you're passionate about – if possible, bring that to bear on your project, be it environmentalism, architecture, technological infrastructure, history, walking, etc.

Over the last weeks of this class, you'll develop this project into something more substantial than previous projects – while past assignments were quick and meant to be exploratory, for the final I'd like you to end up with something more refined and finished. 

The overall form is up to you, but should be dictated by your project. It might be an artwork, online essay, performance, exhibition, proposal for a fictional project, printed book, etc etc etc.

###FINAL PROJECT CALENDAR  
* **Nov 17:** Park projects due, discussion of final project ideas  
* **Nov 24:** Thanksgiving, no class  
* **Dec 1:** Jeff out of town, no class – work on your final projects  
* **Dec 8:** Final projects in progress due, bring concrete work to show and get feedback, work day  
* **Date TBA:** Final presentation and critique (held in the VA&T Lab)  

###READINGS FOR NEXT WEEK  
\[ None, enjoy your Thanksgiving! 🦃 \]
