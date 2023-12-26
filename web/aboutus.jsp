<%
   if (session.getAttribute("name")==null){
      response.sendRedirect("login.jsp");
    }
%>
<!DOCTYPE html>
<html>
<head>
  <meta charset="utf-8" />
  <link rel="icon" href="/favicon.ico" />
  <meta name="viewport" content="width=device-width, initial-scale=1" />
  <meta name="theme-color" content="#000000" />
  <title>About</title>
  <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Source+Sans+Pro%3A300%2C400%2C700"/>
  <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Inria+Serif%3A300%2C400%2C700"/>
  <link rel="stylesheet" href="hnew/styles/about.css"/>
</head>
<body>
<div class="about-iys">
  <div class="auto-group-lg5b-GEh">
    <div class="logo-bar-PaD">
    </div>
    <img class="user-icon-8Xo" src="new/user-icon-Hf3.png"/>
    <img class="shopping-cart-icon-fXj" src="new/shopping-cart-icon-Rnm.png"/>
    <a href="Logout"><p class="blog-15o">Logout</p></a>
    <a href="index.jsp"><p class="home-WYM">Home</p></a>
    <a href="product.jsp"><p class="products-2Wh">Store</p></a>
     <a href="aboutus.jsp"><p class="about-jvu">About</p></a>
   
    <a href="contact.jsp"><p class="contact-us-PEm">Contact us</p></a>
    <img class="rectangle-58-uU1" src="new/rectangle-58-baV.png"/>
  </div>
  <p class="about-us-3q7">About  Us </p>
  <div class="auto-group-n22y-APw">
    <div class="auto-group-qwd3-HUZ">
      <p class="who-we-are-E8u">Who we are</p>
      <p class="welcome-to-green-supermarket-where-our-commitment-to-sustainability-and-health-drives-everything-we-do-at-green-supermarket-we-believe-in-the-power-of-organic-eco-friendly-products-to-not-only-nourish-our-bodies-but-also-nurture-the-planet-our-shelves-are-stocked-with-a-handpicked-selection-of-the-finest-organic-produce-ethically-sourced-goods-and-environmentally-conscious-items-all-aimed-at-promoting-a-healthier-lifestyle-while-reducing-our-ecological-footprint-were-dedicated-to-supporting-local-farmers-and-producers-who-share-our-values-ensuring-that-every-product-on-our-shelves-meets-rigorous-standards-for-quality-freshness-and-sustainability-our-goal-is-to-make-it-effortless-for-you-to-choose-products-that-are-good-for-both-you-and-the-planet-med">Welcome to Green Supermarket, where our commitment to sustainability and health drives everything we do. At Green Supermarket, we believe in the power of organic, eco-friendly products to not only nourish our bodies but also nurture the planet. Our shelves are stocked with a handpicked selection of the finest organic produce, ethically sourced goods, and environmentally conscious items, all aimed at promoting a healthier lifestyle while reducing our ecological footprint. We&#39;re dedicated to supporting local farmers and producers who share our values, ensuring that every product on our shelves meets rigorous standards for quality, freshness, and sustainability. Our goal is to make it effortless for you to choose products that are good for both you and the planet.</p>
    </div>
    <div class="rectangle-4-PZX">
    </div>
  </div>
  <div class="auto-group-pdnm-5hF">
    <div class="rectangle-57-E4M">
    </div>
    <p class="our-specialist-NRT">Our Specialist</p>
    <div class="rectangle-27-HHX">
    </div>
    <p class="at-our-green-supermarket-we-pride-ourselves-on-our-unique-offerings-tailored-to-support-a-sustainable-lifestyle-our-shelves-boast-a-colorful-array-of-fresh-organically-grown-produce-sourced-directly-from-local-farms-dedicated-to-eco-friendly-practices-delve-into-our-bulk-section-a-haven-for-conscious-shoppers-looking-to-reduce-waste-by-filling-their-containers-with-an-assortment-of-grains-nuts-and-seeds-explore-our-artisanal-goods-a-collection-of-handcrafted-delights-from-local-artisans-including-small-batch-bread-cheeses-and-preserves-that-embody-the-passion-of-our-community-unwind-at-our-wellness-corner-where-natural-supplements-herbal-teas-and-organic-personal-care-products-cater-to-your-holistic-well-being-join-our-sustainability-workshops-to-learn-valuable-insights-from-composting-to-eco-friendly-diy-practices-fostering-a-shared-commitment-to-a-greener-healthier-future-for-all-nzy">At our Green Supermarket, we pride ourselves on our unique offerings tailored to support a sustainable lifestyle. Our shelves boast a colorful array of fresh, organically grown produce sourced directly from local farms dedicated to eco-friendly practices. Delve into our bulk section, a haven for conscious shoppers looking to reduce waste by filling their containers with an assortment of grains, nuts, and seeds. Explore our artisanal goods, a collection of handcrafted delights from local artisans, including small-batch bread, cheeses, and preserves that embody the passion of our community. Unwind at our wellness corner, where natural supplements, herbal teas, and organic personal care products cater to your holistic well-being. Join our sustainability workshops to learn valuable insights, from composting to eco-friendly DIY practices, fostering a shared commitment to a greener, healthier future for all.</p>
    <img class="rectangle-25-YmB" src="new/rectangle-25.png"/>
  </div>
  <div class="auto-group-1fem-5FK">
    <p class="faq-Bp9">FAQ</p>
    <div class="rectangle-7-Jds">
    </div>
    <p class="how-can-i-be-sure-that-the-products-in-your-supermarket-are-really-organic-qNu">How can I be sure that the products in your supermarket are really organic?</p>
    <p class="we-source-our-products-from-certified-organic-farms-and-suppliers-look-for-official-organic-certifications-on-the-packaging-ensuring-that-the-product-meets-strict-organic-standards-L4m">We source our products from certified organic farms and suppliers. Look for official organic certifications on the packaging, ensuring that the product meets strict organic standards.</p>
    <p class="yes-we-regularly-offer-discounts-and-promotions-on-various-organic-products-check-our-weekly-specials-and-loyalty-program-for-additional-savings-aE1">Yes, we regularly offer discounts and promotions on various organic products. Check our weekly specials and loyalty program for additional savings.</p>
    <p class="we-are-committed-to-sustainability-we-minimize-packaging-encourage-customers-to-bring-their-reusable-bags-and-implement-recycling-programs-qQq">We are committed to sustainability. We minimize packaging, encourage customers to bring their reusable bags, and implement recycling programs.</p>
    <p class="yes-we-offer-online-ordering-with-convenient-delivery-options-you-can-browse-our-selection-place-orders-and-have-your-organic-products-delivered-to-your-doorstep-hhw">Yes, we offer online ordering with convenient delivery options. You can browse our selection,  place orders, and have your organic products delivered to your doorstep.</p>
    <p class="do-you-have-any-discounts-or-promotions-on-organic-products-xds">Do you have any discounts or promotions on organic products?</p>
    <p class="what-steps-do-you-take-to-reduce-waste-rz9">What steps do you take to reduce waste?</p>
    <p class="can-i-order-products-online-Azq">Can I order products online?</p>
    <img class="badge-1-HZf" src="new/badge-1.png"/>
  </div>
  <div class="auto-group-aers-QuB">
    <div class="logo-bar-Lnq">
    </div>
    <img class="rectangle-58-V9w" src="new/rectangle-58-dss.png"/>
    <p class="every-choice-for-organic-today-nurtures-a-healthier-tomorrow-shop-consciously-at-our-organic-supermarket-and-grow-a-better-world-one-organic-purchase-at-a-time-1e5">Every choice for organic today nurtures a healthier tomorrow. Shop consciously at our organic supermarket and grow a better world, one organic purchase at a time. </p>
    <p class="our-products-23P">Quick links</p>
    <p class="home-LZs">Home</p>
    <p class="products-FRw">Products</p>
    <p class="about-y73">About</p>
    <p class="blog-HNd">Blog</p>
    <p class="contact-us-D1P">Contact us</p>
    <p class="nsbm-green-university-pitipana-thalagala-rd-homagama-sri-lanka-vwP">
    NSBM Green University
    <br/>
    Pitipana - Thalagala Rd,
    <br/>
    Homagama
    <br/>
    Sri Lanka.
    </p>
    <p class="item-94-11-544-5000-94-71-244-5000-2Ud">
    +94 11 544 5000
    <br/>
    +94 71 244 5000
    </p>
    <p class="inquiriesnsbmaclk-8Gm">inquiries@nsbm.ac.lk</p>
    <img class="location-8-eF7" src="new/location-8-8jo.png"/>
    <img class="telephone-8-z45" src="new/telephone-8-myf.png"/>
    <img class="email-8-viR" src="new/email-8-3sj.png"/>
    <p class="blog-TCZ">Copyright © [2023] [Green Organic Supermarket]. All rights reserved.</p>
    <img class="rectangle-59-NqK" src="new/rectangle-59-j2V.png"/>
    <p class="our-products-uaM">Follow us</p>
    <img class="facebook3128208-5-RYh" src="new/facebook3128208-5-oYH.png"/>
    <img class="instagram733614-5-9zV" src="new/instagram733614-5-cHj.png"/>
    <img class="twitter733635-5-6Pw" src="new/twitter733635-5-w81.png"/>
    <img class="whatsapp733641-5-duf" src="new/whatsapp733641-5-253.png"/>
    <img class="twitter733635-6-NsF" src="new/twitter733635-6-tcu.png"/>
  </div>
</div>
</body>