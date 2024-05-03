package org.unlogged.demo.jspdemo.wfm.Controllers;

import org.springframework.web.bind.annotation.RestController;
import org.unlogged.demo.jspdemo.wfm.Models.Entities.BigPojo;

import java.util.ArrayList;
import java.util.List;

@RestController
public class BigObjController {

    private List<Integer> getOrderedList(int n) {
        List<Integer> res = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            res.add(i);
        }
        return res;
    }

    public List<BigPojo> getListofBigPojos() {
        BigPojo bigPojo = new BigPojo();
        bigPojo.setId(10);
        bigPojo.setMake_id(111);
        bigPojo.setModel_id(123);
        bigPojo.setMake_name("Chevrolet Corvette");
        bigPojo.setModel_name("C8 ZO6");
        bigPojo.setPl_id(67);
        bigPojo.setPl_name("Gmf");
        bigPojo.setPl_Description("GM Financial is the wholly owned captive finance subsidiary of General Motors and is headquartered in Fort Worth, Texas. We are a global provider of auto finance solutions, with operations in North America, South America and Asia. Through our long-standing relationships with auto dealers, we offer attractive retail financing and lease programs to meet the needs of each customer. We also offer commercial lending products to dealers to help them finance and grow their businesses.");
        List<Integer> ids = new ArrayList<>();
        ids.add(924);
        ids.add(977);
        ids.add(342);
        ids.add(998);
        bigPojo.setProgram_ids(ids);
        bigPojo.setData_holder_1("Neighbors two blocks away agree, the 670-hp Chevrolet Corvette Z06's cold startup screams good morning, America! The set of pipes attached to Chevy's naturally-aspirated, flat-plane crank 5.5-liter V-8 are nothing short of symphonious, and its parade of horsepower and circular-saw exhaust note celebrate the existence of the greatest Corvette ever built. The Z06 is the most aggressive version of the Corvette Stringray and, although it's still a worthy daily driver, its sharper set of track day tools have turned what was already a great car into a predator. The Z06 is 3.5 inches wider than the Stingray, has an 8500 rpm redline, and offers optional carbon-fiber wheels fitted to Michelin Pilot Sport Cup 2 R ZP race rubber that measures more than 13.5 inches wide at the rear. The Z06 offers the sort of stunning performance you find in ultra-expensive exotics such as the Ferrari 296GTB, but at the much lower starting price of a Porsche Cayman GT4." +
                "Where This Vehicle Ranks : #2 in sports luxury" +
                "What's New for 2024?\n" +
                "Not to worry, the Chevy doesn't shave any of the crazy off the Z06 for 2024. The Z06 earns new colors: Riptide Blue Metallic, Cacti Green, and the optional Sea Wolf Gray Tricoat. Five new accent colors for the available dual racing stripes have been added too. You can now get carbon-fiber wheels with a red stripe, there's a new appearance package for the engine, and the rear video camera mirror is now standard equipment.\n" +
                "\n" +
                "Pricing and Which One to Buy\n" +
                "The price of the 2024 Chevrolet Corvette Z06 starts at $114,395 and goes up to $132,845 depending on the trim and options." +
                "The Corvette Z06's six-figure starting price is no surprise given the car's performance attributes, but it's still a bargain—a couple hundred thousand dollars less—compared to European supercars with similar equipment. We'd go with the base 1LZ Coupe, then it's up to you if want the firmer-riding Z07 Performance package, which adds a track-tuned suspension, Brembo carbon-ceramic brakes, and high-performance Michelin Pilot Cup 2R ZP track tires. Selecting this package also requires adding the Carbon Aero package, which adds carbon-fiber exterior elements, including a front splitter and a rear spoiler. You can also add the Carbon Aero package for the standard Z06, which is how we'd probably order ours.\n" +
                "\n" +
                "Engine, Transmission, and Performance\n" +
                "The new Corvette Z06 receives a special engine that makes it sound similar to the supercars it's trying to dethrone. Its naturally aspirated 5.5-liter V-8 features a flat-plane crank and revs to 8500 rpm. The engine produces 670 horsepower and has a Ferrari-like howl that'll send shivers down your spine—and have bystanders swiveling in your direction. The unconventional V-8 hooks up to an eight-speed dual-clutch automatic transmission and rear-wheel drive. Performance is explosive: at our test track, the Z06 coupe blasted to 60 mph in just 2.6 seconds and sailed through the quarter-mile mark in 10.5 seconds at 131 mph. The convertible needed just 0.1 second longer to reach 60 mph in our testing. A set of wider, stickier tires and more powerful brakes help it corner harder and stop shorter than the regular Vette. Chevy also has strengthened the Corvette's structure and transformed the chassis to ensure the Z06's performance advantages are most obvious at the racetrack. To unlock its full potential, an optional Z07 package adds aerodynamic elements, reduces weight, and further upgrades the brakes and tires. The car comes standard with 20-inch front and 21-inch rear forged aluminum wheels, but a set of lighter and stronger carbon-fiber rollers are optional. We also tested a 2023 Corvette Z06 as part of a 0-to-150-to-0 speed test where it returned to a stop in just 22.5 seconds, beating its nemesis, a Porsche 911 GT3 RS, by almost two seconds." +
                "Fuel Economy and Real-World MPG\n" +
                "The Z06's EPA fuel economy estimates of 12 mpg city and 19 mpg highway make the Chevrolet Silverado pickup truck look efficient. When we get a chance, we'll take the Z06 on our 75-mph highway fuel economy test route and update this story with its real-world results. For more information about the Corvette Z06's fuel economy, visit the EPA's website.\n" +
                "\n" +
                "Interior, Comfort, and Cargo\n" +
                "The Bow Tie brand went above and beyond to ensure that the mid-engine Corvette's interior could not be called boring. While the design certainly transcends what's found on every other Chevy model, the square steering wheel and wall of climate-control buttons on the center console are unusual elements, to say the least. Still, the cabin layout caters to the driver, and the list of standard and optional features is extensive. It includes a digital gauge cluster, a head-up display, heated and ventilated seats, and even wireless phone charging. Its track-worthiness is made more apparent inside with microsuede accents and more aggressively bolstered seats, as well as two carbon-fiber-intensive interior packages. The Corvette's capacious rear trunk should continue to provide a spot for drivers to carry two sets of golf clubs." +
                "Infotainment and Connectivity\n" +
                "Cooked into the Corvette's multilayered dashboard is an 8.0-inch touchscreen infotainment system. It includes Apple CarPlay, Android Auto, and a Wi-Fi hotspot. Likewise, two separate Bose stereos are offered: a standard 10-speaker system and an optional 14-speaker setup. The Z06 also offers a Performance Data Recorder (PDR), which allows you to record video of everything from your track exploits to relaxed country-road cruises. And if you dare leave your Z06 with a valet, there's a setting that keeps track of any nefarious activities the car parker might try." +
                "Safety and Driver-Assistance Features\n" +
                "The base Corvette Stingray offers a handful of driver-assistance technology, and those features are available on the Z06. For more information about its crash-test results, visit the National Highway Traffic Safety Administration (NHTSA) and Insurance Institute for Highway Safety (IIHS) websites. Key safety features include:\n" +
                "\n" +
                "Standard rear parking sensors\n" +
                "Available multi-view camera system\n" +
                "Available blind-spot monitor and rear cross-traffic alert\n" +
                "Warranty and Maintenance Coverage\n" +
                "Chevy provides all of its models with a middle-of-the-road limited and powertrain warranty. While the company offers more complimentary maintenance than automakers who skip the free service altogether, it's one of the industry's shortest plans.\n" +
                "\n" +
                "Limited warranty covers three years or 36,000 miles\n" +
                "Powertrain warranty covers five years or 60,000 miles\n" +
                "Complimentary maintenance is covered for the first visit");
        bigPojo.setData_holder_2("From Wikipedia, the free encyclopedia\n" +
                "This article is about the eighth generation of the Chevrolet Corvette sports car. For general Corvette information, see Chevrolet Corvette.\n" +
                "Chevrolet Corvette (C8)\n" +
                "\n" +
                "Chevrolet Corvette (C8) Stingray\n" +
                "Overview\n" +
                "Manufacturer\tChevrolet (General Motors)\n" +
                "Also called\tGMSV Chevrolet Corvette (Australia)\n" +
                "Production\tFebruary 2020–present[1]\n" +
                "Model years\t2020–present\n" +
                "Assembly\tUnited States: Bowling Green, Kentucky (Bowling Green Assembly Plant)[2]\n" +
                "Designer\tTom Peters (2015)[3]\n" +
                "Body and chassis\n" +
                "Class\tSports car (S)\n" +
                "Body style\t\n" +
                "2-door targa top\n" +
                "2-door retractable hardtop convertible[4]\n" +
                "Layout\tRear mid-engine, rear-wheel-drive\n" +
                "Rear mid-engine, four-wheel-drive (E-Ray)\n" +
                "Platform\tGeneral Motors Y2XX\n" +
                "Powertrain\n" +
                "Engine\t6.2 L LT2 crossplane OHV V8 (Stingray and E-Ray)\n" +
                "5.5 L LT6 flat-plane DOHC V8 (Z06)\n" +
                "Electric motor\t1x Permanent magnet synchronous motor (E-Ray)\n" +
                "Power output\t490–495 hp (365–369 kW; 497–502 PS) (Stingray)\n" +
                "655 hp (488 kW; 664 PS) (E-Ray, combined)\n" +
                "670 hp (500 kW; 679 PS) (Z06)\n" +
                "Transmission\tTremec TR-9080 DCT 8-speed dual clutch transmission[5]\n" +
                "Hybrid drivetrain\tThrough the Road Hybrid (E-Ray)\n" +
                "Battery\t1.9 kWh (E-Ray)\n" +
                "Dimensions\n" +
                "Wheelbase\t107.2 in (2,723 mm)\n" +
                "Length\t182.3 in (4,630 mm)\n" +
                "Width\t76.1 in (1,933 mm)\n" +
                "Height\t48.6 in (1,234 mm)\n" +
                "Curb weight\t3,647–3,913 lb (1,654–1,775 kg)[6][7]\n" +
                "Chronology\n" +
                "Predecessor\tChevrolet Corvette (C7)\n" +
                "The Chevrolet Corvette (C8) is the eighth generation of the Corvette sports car manufactured by American automobile manufacturer Chevrolet. It is the first rear mid-engine Corvette since the model's introduction in 1953, differing from the traditional front mid-engine design started in 1963. The C8 was announced in April 2019, and the coupe made its official debut on July 18, 2019, in Tustin, California. The convertible made its debut in October 2019 during a media event at the Kennedy Space Center to coincide with the 50th anniversary of the Apollo 11 mission. The racing version, the Chevrolet Corvette C8.R, also made its debut that same month.[8] Production officially began on February 3, 2020, delayed by the 2019 General Motors strike.[1]" +
                "Following several experimental CERV prototype vehicles, the C8 is GM's first production rear mid-engine sports car since the Pontiac Fiero was discontinued. It features a vastly different design from previous Corvettes, with an all-new aluminum architecture and coil-over springs in place of leaf springs used on prior models. The exterior features more aggressive aerodynamics including larger air intakes and prominent side scoops. A trunk is located at the rear, with additional storage space at the front of the car. Combined, these provide 13 cubic feet (370 L) of cargo space, 2 cubic feet (57 L) less than that of the C7.[9] As a result of the switch to a mid-engine layout, the passenger cell has been shifted forward by 16.5 inches (420 mm).[10] The cockpit has been designed to be driver-centric, with numerous controls mounted on the center console as well as utilizing a new hexagonal steering wheel. A 12 in (30.5 cm) digital screen replaces the instrument cluster and reflects one of the six driving modes selected, and is accompanied by an 8 in (20.3 cm) touchscreen. A special Z button (a homage to Zora Arkus-Duntov \"Father of the Corvette\") is also mounted on the steering wheel; this can quickly activate customized performance settings.[11]" +
                "Trim levels and options\n" +
                "\n" +
                "GT1, GT2, Competition Sport seat options\n" +
                "Three trim levels are currently available, 1LT, 2LT and 3LT, augmented by three suspension setups, FE1, FE3 and FE4 which correspond with the two Z51 Performance packages. In addition, three seat options are also available: GT1, GT2 and Competition Sport. The interior is upholstered in leather, microsuede or performance textile with carbon fiber or aluminum trims. A Performance Data Recorder has been upgraded with a higher resolution camera as well as a new interface. GM's virtual camera mirror is optional, which projects video from the backup camera onto the rear view mirror.[12][13]\n" +
                "\n" +
                "Engine\n" +
                "\n" +
                "The LT2 V8 engine\n" +
                "The Stingray uses a new version of the LS-based GM small-block engine derived from the C7 Stingray's LT1, now called the LT2.[14] The new naturally aspirated 6.2 L V8 is rated at 490 hp (365 kW; 497 PS) at 6,450 rpm and 465 lb⋅ft (630 N⋅m) of torque at 5,150 rpm, an improvement of 40 hp (30 kW; 41 PS) and 10 lb⋅ft (14 N⋅m) over the outgoing C7 Corvette Stingray.[15] The engine uses dry sump lubrication system.[16] Like the C7, the C8 features Active Fuel Management, or cylinder deactivation, which is used when the car is subjected to low load scenarios such as highway cruising.[17][18]\n" +
                "\n" +
                "The engine has two radiators, one on each side in the front. The Z51 package includes a third radiator, a water-to-water and water-to-oil radiator on the rear driver's side, cooling both engine oil and transmission lubricant, taking air in through the rear quarter panel opening.[19]\n" +
                "\n" +
                "The optional NPP sport exhaust system brings the total power output to 495 hp (369 kW; 502 PS) and torque to 470 lb⋅ft (637 N⋅m).[20] Chevrolet claims that the C8 can accelerate to 60 mph (97 km/h) in 2.9 seconds when equipped with the optional Z51 package;[12] Car and Driver recorded a time of 2.8 seconds (by subtracting a 1-foot rollout).[21]\n" +
                "\n" +
                "Transmission\n" +
                "\n" +
                "Transmission cutout\n" +
                "The Stingray is only offered with an 8-speed dual-clutch automated transmission[22] made by Tremec, with paddle shifters on the steering wheel.[23] No manual transmission option is available. The only other model years not offered with a manual transmission were the 1953–1954 C1 and the 1982 C3.[12][24]\n" +
                "\n" +
                "Suspension\n" +
                "The base model of the Stingray comes with unequal length double wishbone suspension at the front and rear axles made from forged aluminum.[25] Monotube shock absorbers are standard at all four wheels. The car can be equipped with a front-axle lifting height adjustable suspension system that can add 2 in (40 mm) of ground clearance at speeds under 25 mph (40 km/h).[26]\n" +
                "\n" +
                "The Z51 package adds a performance-tuned adjustable suspension with higher front and rear spring rates and firmer dampers.[27] The front shocks, on vehicles without hydraulic front lift, and the rear shocks, have threaded spring seats that allow adjustment of the preload on the coil springs.[28] Additionally, the spring seat can be adjusted approximately 20 mm (0.8 in) up or down from the nominal position.[28]\n" +
                "\n" +
                "Magnetic Selective Ride Control is an available option for all trims and levels. On Z51 equipped Corvettes, Magnetic Selective Ride Control includes Performance Traction Management and electronic limited-slip differential (eLSD).[29]\n" +
                "\n" +
                "Wheels\n" +
                "The Stingray is equipped with 19 in (48 cm) (front) and 20 in (51 cm) (rear) alloy wheels and Michelin Pilot Sport ALS tires, with Michelin Pilot Sport 4S tires available as a part of the Z51 performance package. All-season tires are used on base models for better grip.[30] The exact tire dimensions are 245/35ZR-19 at the front and 305/30ZR-20 at the rear.[12] The standard brakes are four-piston Brembo ventilated discs with diameters of 12.6 in (320 mm) at the front and 13.6 in (345 mm) at the rear. The Z51 package provides upgraded and enlarged brakes measuring 13.3 in (338 mm) at the front and 13.8 in (351 mm) at the rear.[25]\n" +
                "\n" +
                "Technology\n" +
                "The C8 Corvette debuted with an 8-inch infotainment screen in a driver centric cockpit. It comes standard with Chevrolet's Infotainment 3 Plus system. Standard features include Bluetooth connectivity, 4G hotspot, and both Android Auto and Apple CarPlay. Higher trims are equipped with a 14-speaker Bose audio system and navigation options. Additional technology features include a performance data recorder package for 2LT and 3LT trim levels as well as a camera based rear view mirror.[31] The 2020 Corvette was the first year Chevrolet introduced over the air updates to the Corvette line-up. This allows Chevrolet to send updates to the vehicle remotely. Chevrolet used this capability to resolve a front trunk recall for the 2020 Corvettes.[32]\n" +
                "\n" +
                "Right-hand-drive (RHD)\n" +
                "For the first time since the 1953 introduction of the Corvette (C1), the current generation Corvette is offered in right-hand-drive configuration for the Australian, New Zealand, Japanese, and UK markets.[33][34] The Corvette (C8) is General Motors' only RHD vehicle to be assembled in the factory rather than converted from left-hand-drive. After the pre-sale announcement, 300 RHD Corvettes were sold within sixty hours: a record for the Corvette sales in Japan and three times the annual sales number for its left-hand-drive predecessor.[35] The introduction of RHD Corvette for Australian market was delayed to the middle of 2021 due to the reorganization of Holden Special Vehicles (HSV) into GMSV (General Motors Special Vehicles) which also brings GM vehicles into New Zealand. Only 200 RHD Corvettes will be sold in Australia per year, and the price is set at $149,990 AUD with higher performance versions above $200,000 AUD. The first sales of the RHD C8 in New Zealand were 28 cars in 2022.[36][37]" +
                "Z06\n" +
                "\n" +
                "2023 Chevrolet Corvette Z06 at 2022 Chicago Auto Show\n" +
                "The performance version of the Corvette, the Z06, was unveiled on October 26, 2021. The Z06 entered production as a 2023 model year as a homologation vehicle.[38]\n" +
                "\n" +
                "Trim levels and options\n" +
                "The Z06 has three trim levels adding various interior comfort and technology upgrades: 1LZ, 2LZ, and 3LZ. Additionally, the Z07 Performance Package can be applied to any trim that adds improved brakes, carbon fiber aerodynamic elements, suspension tuning, and performance tires.[39]\n" +
                "\n" +
                "Engine\n" +
                "\n" +
                "Chevrolet LT6, flat-plane crank V8\n" +
                "The Z06 uses a new naturally aspirated 5.5 L V8 producing 670 hp (500 kW; 679 PS) at 8,400 rpm, 460 lb⋅ft (624 N⋅m) of torque at 6,300 rpm and has a redline of 8,600 rpm.[40][41] This engine, dubbed the LT6, features a double overhead camshaft (DOHC) and a flat-plane crank, and surpasses the Mercedes-Benz SLS AMG Black Series' M159 engine to become the most powerful naturally aspirated production V8.[42] A modified version of this engine has powered the Chevrolet Corvette C8.R since 2019, and many features in the racing engine carry over to the road engine.[43] Other features of this new engine include a cast aluminum block, dual coil valve springs supporting titanium intake & sodium filled exhaust valves, forged aluminum pistons, forged titanium connecting rods, active split intake manifold with twin 87mm throttle bodies, four-into-two-into-one stainless steel exhaust headers, and a factory six-stage 10-quart dry sump oiling system with individual crank bay scavenging.[41] A feature the LT6 shares with other Chevrolet small blocks is the bore spacing of 4.4 inches.[41][43]\n" +
                "\n" +
                "Transmission\n" +
                "The Z06 uses the same 8-speed dual-clutch transmission used by Stingray models, albeit with a shorter 5.56:1 final drive ratio for improved acceleration. Chevrolet claims this allows the Z06 to accelerate from 0–60 mph (0–97 km/h) in 2.6 seconds.[44]\n" +
                "\n" +
                "Suspension\n" +
                "The Z06 features the same basic suspension setup as the Stingray, however the electronic limited-slip differential and magnetic ride adaptive suspension system are now standard for all Z06 trims. The Z07 Performance Package includes the FE7 track-oriented suspension setup.[39]\n" +
                "\n" +
                "Wheels\n" +
                "The Z06's body has been widened to accommodate larger wheels and thicker tires. The wheels have diameters of 20 inches (51 cm) at the front and 21 inches (53 cm) at the rear, and are available with standard alloy or optional carbon fiber rims. The tires have dimensions of 275/30ZR20 at the front and 345/25ZR21 at the rear, and the Z07 Performance Package comes standard with Michelin Cup 2 R ZP performance tires.[45] Chevrolet claims that the optional carbon fiber wheels, supplied by Australian manufacturer Carbon Revolution,[46] shave off 41 lb (19 kg) of unsprung weight.[47]\n" +
                "\n" +
                "Aerodynamics\n" +
                "The base Z06 comes with a front splitter and a rear spoiler. Under the splitter are stall gurneys to reduce drag.[48] Included with the rear spoiler is an installable fixed Gurney flap, which when installed produces 365 lb (166 kg) pounds more downforce at 300 km/h (186 mph). The Z07 carbon fiber performance package adds a larger front-splitter, front corner canards (dive planes), a pedestal mounted rear wing, and underbody aero strakes, and removes the stall gurneys under the splitter for additional downforce.[41] Chevrolet claims that with all these equipped and in the track configuration, the Z06 is capable of 1.22g lateral acceleration on a skidpad.[41][49]\n" +
                "\n" +
                "Performance\n" +
                "Chevrolet claims a 10.6-second quarter-mile time for the Z06 model when equipped with the Z07 package. The C8 Z06 is able to reach top speeds in excess of 200 miles per hour (320 km/h).[50]\n" +
                "\n" +
                "E-Ray\n" +
                "\n" +
                "Chevrolet Corvette E-Ray\n" +
                "The performance hybrid version of the Corvette, the E-Ray, was unveiled on January 17, 2023. The E-Ray will enter production as a 2024 model year and will be the quickest Corvette ever made as well as the first with all wheel drive and the first hybrid.[51]\n" +
                "\n" +
                "Trim levels and options\n" +
                "The E-Ray has three trim levels adding various interior comfort and technology upgrades: 1LZ, 2LZ, and 3LZ. Additionally, there will be a ZER Performance Package that can be applied to any trim and It will include summer only tires as well as chassis tuning. The E-Ray will come standard with Carbon Ceramic brakes and an eAWD drivetrain.[52]\n" +
                "\n" +
                "Performance\n" +
                "Chevrolet claims a 10.5-second quarter-mile time and a 0-60 time of 2.5 seconds making it the quickest Corvette to date in those categories.\n" +
                "\n" +
                "Modes\n" +
                "Stealth Mode allows for all-electric driving at a maximum speed of 45 mph. Designed for quietly leaving the neighborhood.[53]\n" +
                "\n" +
                "Model year changes\n" +
                "2020 model year\n" +
                "The first production model of the C8 Corvette was the Stingray with a new mid-mounted 6.2 L LT2 V8 engine. It was available as a 2-door targa top or a retractable hardtop convertible. The targa top was available in body color, transparent, or visible carbon fiber.\n" +
                "\n" +
                "2021 model year\n" +
                "Trim levels and options\n" +
                "2021 saw a list of changes following the 2020 launch year of the C8 Corvette. Long Beach Red Metallic Tintcoat and Blade Silver Metallic were retired. Red Mist Metallic Tintcoat and Silver Flare Metallic were added as premium color options. Additionally, full length racing stripes saw 4 new color options.[54]\n" +
                "\n" +
                "The interior saw the addition of Sky Cool Gray / Strike Yellow color available only on the 3LT.[55] Magnetic Ride became available separate to the Z51 package for the 2021 model year. The Z51 package saw a price increase from $5,000 to $5,995 starting 2021. The front lift saw an increase from $1,495 to $1,995 as well.[56]\n" +
                "\n" +
                "Wireless Apple CarPlay and Android Auto became standard options in 2021. Black Trident Spoke wheels, all weather floor liners, and carbon fiber mirror covers all saw minor price increases as well.[57]\n" +
                "\n" +
                "The 2021 C8 received a base price increase, mid way through the production cycle. Chevrolet raised the base price by $1000, putting it over the $60,000 threshold. The price increase was effective for all orders entered after March 1, 2021. The increase was attributed to a fluctuation in supplier parts costs as well as the global chip shortage which has delayed production in the automotive sector as a whole.[58]\n" +
                "\n" +
                "The end of the 2021 production year also saw the end of Sebring Orange, Shadow Gray, and Zeus Bronze as exterior color options.[59]\n" +
                "\n" +
                "Production\n" +
                "The 2021 Corvette started production on December 8, 2020, due to extended production of the 2020 model year.[60] The 2021 model year saw production issues due to parts constraints.[61] Chevrolet also increased the base price of the Corvette by $1,000 in the middle of the 2021 model year, to $60,995.[62]\n" +
                "\n" +
                "2022 model year\n" +
                "The LT2 saw fuel management system upgrades for the 2022 model year which featured a new fuel pump and injectors. The base price was also increased $1200 to compensate for increased supplier costs. A new IMSA GTLM Championship Edition package, limited to 1000 units, was introduced for 2022.[63]\n" +
                "\n" +
                "The 2022 model year saw the introduction of Caffeine Metallic, Amplify Orange Tintcoat, and Hypersonic Gray as new color options.[64]\n" +
                "\n" +
                "2023 model year\n" +
                "GM and Chevrolet started production of the 2023 model year in the spring of 2022. 2023 saw multiple price increases early into the production year. In March, it was announced that the 2023 model year would see a $1000 base price increase. In May, the destination charge saw a minor $100 increase. During the start of production and launch of the 2023 configurator, GM raised the base price of the 2023 Corvette by $2300 making the new base price $65,595.[65][66] Several packages and options saw increases and adjustment to pricing.\n" +
                "\n" +
                "2023 also received a special edition variation of the Corvette to commemorate its 70th anniversary since the launch of the Corvette model. The 2023 Corvette Stingray 70th Anniversary Edition is a $5995 package atop the 3LT trim level. The special edition was offered in two exclusive colors of White Pearl Metallic Tri-Coat and Carbon Flash Metallic. Additionally, the package came with special wheels, badging, and VIN sequence to commemorate the vehicle's 70th year in the US market.[67]\n" +
                "\n" +
                "In addition to changes to the base Corvette, the Corvette Z06 was introduced with a 5.5 L LT6 V8 engine.[40]\n" +
                "\n" +
                "2024 model year\n" +
                "The 2024 Corvette started production in the summer of 2023. The base price of the standard C8 went up from $64,500 to $66,300 (an increase of $1800), whereas the price of the C8 Z06 went up from $105,300 to $108,100 (an increase of $2800) No limited edition packages have been added, however some additional options have. For example, more carbon fiber elements (such as a carb fiber high wing and door mirror caps) have been added to the 2LT trim, a new carbon fiber spoiler styled after the Z06 high wing is now available for the base C8, and carbon fiber wheels with a red trim are now available as a top end option for the Z06.\n" +
                "\n" +
                "As of Summer 2023, the brand new hybrid Corvette C8 E-ray is now available, starting at $102,900.");
        bigPojo.setData_holder_3("2023 Chevy Corvette Z06 First Drive Review: America's Supercar\n" +
                "After reinventing the Corvette as a mid-engine machine, Chevy transforms the C8 chassis into a street-legal race car with the high-revving, 670-hp Z06 model.\n" +
                "\n" +
                "Updated Oct. 4, 2022 2:00 a.m. PT\n" +
                "antuan-roadshow-headshots-jpegs-1893-007.jpg\n" +
                "Written by \n" +
                "Antuan Goodwin\n" +
                "Our expert, award-winning staff selects the products we cover and rigorously researches and tests our top picks. If you buy through our links, we may get a commission. Reviews ethics statement\n" +
                "antuan-roadshow-headshots-jpegs-1893-007.jpg\n" +
                "Antuan Goodwin\n" +
                "Reviews Editor / Cars\n" +
                "Antuan Goodwin gained his automotive knowledge the old fashioned way, by turning wrenches in a driveway and picking up speeding tickets. From drivetrain tech and electrification to car audio installs and cabin tech, if it's on wheels, Antuan is knowledgeable.\n" +
                "Expertise\n" +
                "Reviewing cars and car technology since 2008 focusing on electrification, driver assistance and infotainment\n" +
                "Credentials\n" +
                "North American Car, Truck and SUV of the Year (NACTOY) Awards Juror\n" +
                "See full bio\n" +
                "CNET logo\n" +
                "Why You Can Trust CNET\n" +
                "16\n" +
                "17\n" +
                "18\n" +
                "19\n" +
                "20\n" +
                "21\n" +
                "22\n" +
                "23\n" +
                "24\n" +
                "25+\n" +
                "Years of Experience\n" +
                "14\n" +
                "15\n" +
                "16\n" +
                "17\n" +
                "18\n" +
                "19\n" +
                "20\n" +
                "21\n" +
                "22\n" +
                "23\n" +
                "Hands-on Product Reviewers\n" +
                "6,000\n" +
                "7,000\n" +
                "8,000\n" +
                "9,000\n" +
                "10,000\n" +
                "11,000\n" +
                "12,000\n" +
                "13,000\n" +
                "14,000\n" +
                "15,000\n" +
                "Sq. Feet of Lab Space\n" +
                "CNET’s expert staff reviews and rates dozens of new products and services each month, building on more than a quarter century of expertise. Read how we test products and services.\n" +
                "\n" +
                "Table of Contents\n" +
                "2023 Chevy Corvette Z06 First Drive Review: America's Supercar\n" +
                "670-hp flat-plane V8\n" +
                "On the road\n" +
                "On the track\n" +
                "The Z07 Performance package\n" +
                "Pricing and availability\n" +
                "The new Chevrolet Corvette Stingray is a total reinvention of the Corvette formula with its mid-engine layout and nimble, neutral driving characteristics. It's an excellent sports car and, despite its exotic appearance, a fairly capable grand tourer with a comfortable ride and two (count 'em, two!) trunks.\n" +
                "\n" +
                "The new Z06 expresses the C8 Corvette's wild side with a new, race-bred, high-revving V8 engine, more aerodynamic and mechanical grip than ever before and an exhaust note that's more formula car wail than muscle car roar. The 2023 Corvette Z06 is unlike any street car that Chevy's built before.\n" +
                "\n" +
                "670-hp flat-plane V8\n" +
                "We first learned of the new 5.5-liter naturally aspirated V8 when the Z06 made its official debut around this time last year. As a refresher, the LT6 makes use of dual overhead cams, a flat-plane crank, dry sump lubrication and one heck of an exotic intake manifold to spin out 670 horsepower and 480 pound-feet of torque. Even without forced induction, that's 20 hp more than the supercharged LT4 V8 it replaces with a 15-pound weight reduction to boot.\n" +
                "\n" +
                "The LT6 is down on torque -- by 170 lb-ft to be precise -- but with a longer sweep, crescendoing at an 8,600 rpm redline, it's thrilling enough that you won't notice. The engine's ultra-light internals, short stroke and flat-plane firing order were engineered to make most of its power at high revs. Meanwhile, the C8 Z06's exhaust has been completely redesigned to emphasize this high-strung character." +
                "The Z06's flat-plane V8 is hand-built by a single master technician whose signature can be found on the intake manifold. Hi, Andy!\n" +
                "Antuan Goodwin/CNET\n" +
                "Buyers expecting the deep, loping V8 rumble of the previous generation Z06 may find themselves disappointed. This is a totally different engine with a completely different temperament and sound, but it fits nicely with the rest of the Z06's more exotic, mid-engine groove. I love it.\n" +
                "\n" +
                "On the road\n" +
                "From the driver's seat, the Z06 is noticeably louder around town than the base Stingray, but not in the way you might expect. The exhaust sings loudly when matting the throttle for a 2.7-second 0-to-60-mph dash -- and the induction noise coming from just behind the driver's shoulder is nearly as pronounced -- but the LT6 isn't terribly noisy at moderate speeds. " +
                "The tires are a different story; road noise is pronounced. The Z06 is 3.6 inches wider than the Stingray, a change necessary to accommodate a wider track, but also larger tires. Up front are 20-inch wheels wrapped with 275/30ZR20 Michelin Pilot Sport 4S tires and out back are 21s with 345/25ZR21 rubber. I'll do the math for you: That's a 13-inch-wide contact patch for each of the rear tires; they're going to make some noise over bumps, imperfections and road textures. I wouldn't call it a dealbreaker -- certainly it's par for the performance course and worth the gain in grip -- but worth noting for the majority of prospective owners who plan to daily drive their American exotic.\n" +
                "\n" +
                "Trackside With the 2023 Chevy Corvette Z06" +
                "The Z06's standard Magnetic Ride Control suspension is also around 30% stiffer than the Stingray with the Z51 Performance package in its Sport setting. Leave it in the Touring mode and the Z06 is comfortable enough to daily drive or commute. Touring mode is also the standard eight-speed dual-clutch transmission's most mild-mannered setting with immediate but smooth shifts.\n" +
                "\n" +
                "Thankfully, the Z06 doesn't ride any lower than the Stingray -- which is already an extremely low-slung coupe -- and the performance variant can even be had with the same optional front lift feature that can raise the nose by 1.8 inches automatically at GPS-set locations. The lift works manually, as well, to clear steep driveways, speed bumps or other obstructions -- an especially helpful feature for keeping the optional aero kit's carbon fiber front splitter unmarred.\n" +
                "\n" +
                "Inside, you'll find unique sports seats and racy trim, but it's no surprise that the Z06's cabin features the same tech found on the Stingray. The dashboard is highlighted by an 12-inch digital instrument cluster and an 8-inch version of Chevrolet's excellent Infotainment 3 system. Android Auto and Apple CarPlay are standard, which Chevy specifically had us use to navigate the drive route rather than the optional onboard navigation software. The Z06 also retains the Stingray's digital rear view mirror, an invaluable bit of tech if you actually want to see anything behind you past the backlight, the sloped rear glass with engine bay reflections and the massive carbon fiber wing, if so equipped.\n" +
                "\n" +
                "On the track\n" +
                "The Z06's capabilities require a track to be exercised, so we headed to the Pittsburgh International Race Complex, a lesser known yet quite challenging course, and one of many that Chevy used to help tune the vehicle's performance. Heading out for a few warmup lead-follow laps behind one of Chevy's development drivers, I cautiously eased the 'Vette around the unfamiliar track. I was so cautious during those first few laps that Chevrolet's engineers pulled me aside to offer a few tips for maximizing the Z06's performance.\n" +
                "\n" +
                "2023 Chevrolet Corvette Z06 rear wing and lights\n" +
                "Enlarge Image\n" +
                "The uprights for the Carbon Aero rear wing go all the way through the body and are supported by the bumper structure.\n" +
                "Antuan Goodwin/CNET\n" +
                "The hardest thing was keeping my foot in it and not short shifting. The Z06 revs much higher than any Corvette before, and my instinct was to grab the paddle shifter 1,500 to 2,000 rpm short of the 8,600-rpm redline. That leaves a lot of power on the table. Letting the well-programmed DCT handle shifting for a few laps helped train my ears to the sound and rhythm of the Z06's powertrain and recalibrate my shift points.\n" +
                "\n" +
                "Next up was learning to trust the brakes. Chevy outfits the Z06 with huge 12.6-inch front brakes with six-piston calipers and even larger 14.9-inch rear discs grabbed by 4-pots -- an odd combo, but an effective one that's easy to modulate. Combined with the massive, sticky contact patches, there's no shortage of stopping power, and I was encouraged to brake later and harder as my confidence in the Z06 grew with each successive lap.\n" +
                "\n" +
                "The Z06 proved to be a willing and communicative track partner with a generous, forgiving performance envelope and great steering feedback. I could have spent dozens of laps shaving down my time and each would be more rewarding than the last, but I didn't have time for that. So after sliding into the passenger seat for a few final hot laps with Chevy's driver -- an eye-opening experience that showed me just how much performance and speed I was still leaving untapped -- it was time to swap into the Z07.\n" +
                "\n" +
                "The Z07 Performance package\n" +
                "The 2023 Chevrolet Z06 with the Z07 Performance package is built around taking full advantage of the upgraded ultra-high performance Michelin Pilot Sport Cup 2 R tires. In addition to the street-legal race rubber, you get standard carbon-ceramic brakes with larger 15.7-inch front rotors and a retuned magnetic suspension that is 10% firmer than the Z06 in Sport or Track modes. The Z07 also makes the carbon aero kit with its large rear wing, front splitter, dive planes and underbody strakes standard equipment. Together, the aero bits generate up to 734 pounds of downforce at 186 mph, more than double that of the base Z06's aero.\n" +
                "\n" +
                "Stepping up to a higher tier of performance is usually intimidating, but the Z07 is surprisingly much easier to drive quickly than the base Z06. It is, after all, the same car just with significantly more grip. Around tight corners and high-speed sweeping bends, the Z07 felt yet again like a car transformed with even more of the chassis' potential unlocked. Of course, my skill cap still fell short of the Z07's capability for pure unhinged speed, yet even as I found myself approaching and testing the seemingly unlimited grip, the handling proved to be pleasantly neutral with excellent seat-of-the-pants feel and an almost telepathically communicative chassis. \n" +
                "\n" +
                "On my final lap, for example, the Z07 began to oversteer over a mid-corner crest on a left-handler that I've taken too fast. The grip gave progressively, the slight over-rotation felt instantly through the seat. With just the right amount of countersteer, I felt the grip hook up again, catching the slide perfectly and pulling the tail back in line. Going from cautious and unsure to that intimately connected within the span of an hour is possibly the highest praise I can heap on the Z07's formula.\n" +
                "\n" +
                "2023 Chevrolet Corvette Z06\n" +
                "Enlarge Image\n" +
                "The Z06 needs to be experienced on a track in order to be appreciated.\n" +
                "Chevrolet\n" +
                "Pricing and availability\n" +
                "With production of the Ford GT being discontinued this year and the SRT Viper long gone, the Z06 stands unchallenged as America's supercar and must go hunting overseas for worthy rivals. Chevy is targeting the much more expensive Porsche 911 GT3, Lamborghini Huracan Evo, McLaren 720S and Ferrari F8 Tributo as its primary competitors.\n" +
                "\n" +
                "The 2023 Chevrolet Corvette Z06 starts at $106,395 for the base 1LZ Coupe or $113,895 for the Convertible. That price includes the requisite $1,395 destination charge. The $8,995 Z07 Performance package requires the $8,495 painted carbon aero package (or $10,495 for exposed carbon fiber), so you're looking at $123,885 minimum for the most track-ready version before options. (And you're going to want options, I'm sure, so check out our price breakdown for more details.) \n" +
                "\n" +
                "Most Z06 drivers -- even those who opt for the Z07 spec -- will log the vast majority of their miles on public roads. Many will never see a circuit, which is a shame because the 2023 Chevrolet Corvette Z06 is one of the few race-bred American sports cars that actually walks the walk. This car truly needs a track in order to stretch its legs and be appreciated.  \n" +
                "\n" +
                "Editors' note: Travel costs related to this story were covered by the manufacturer, which is common in the auto industry. The judgments and opinions of CNET's staff are our own and we do not accept paid editorial content.");
        List<BigPojo> bigPojos = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            bigPojos.add(bigPojo);
        }
        return bigPojos;
    }
}
